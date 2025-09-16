package prgi;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class myclient {

    public static void main(String args[]) {
        try {
            Socket s = new Socket("localhost", 115);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner sc = new Scanner(System.in);
            DataInputStream dis = new DataInputStream(s.getInputStream());

            System.out.println("Enter the number of frames to send ");
            int n = sc.nextInt();
            String k = Integer.toString(n);
            dout.writeUTF(k);

            for (int i = 0; i < n; i++) {
                System.out.println("Enter frame " + (i + 1));
                String fr = sc.next();
                dout.writeUTF(fr);
                String ack = dis.readUTF();
                System.out.println(ack + " for frame " + (i + 1));
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