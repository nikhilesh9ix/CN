package prgi;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String args[]) {
        try {
            Socket s = new Socket("localhost", 118);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the number of frames to send");
            int n = sc.nextInt();
            dout.writeUTF(String.valueOf(n));

            System.out.println("Enter send window size ");
            int sendwindow = sc.nextInt();

            for (int i = 0; i < n; ) {
                int framesToSend = Math.min(sendwindow, n - i);
                System.out.println("\nSending a window of " + framesToSend + " frames.");

                for (int j = 0; j < framesToSend; j++) {
                    System.out.print("Enter frame " + (i + j + 1) + ": ");
                    String fr = sc.next();
                    dout.writeUTF(fr);
                }

                for (int j = 0; j < framesToSend; j++) {
                    String ack = dis.readUTF();
                    System.out.println("Received " + ack + " for frame " + (i + j + 1));
                }
                i += framesToSend;
            }

            dout.close();
            dis.close();
            s.close();
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}