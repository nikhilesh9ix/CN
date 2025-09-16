package prgi;

import java.io.*;
import java.net.*;

public class mysender {

    public static void main(String args[]) {
        try {
            ServerSocket sr = new ServerSocket(118);
            System.out.println("Server started. Waiting for client...");
            Socket s = sr.accept();
            System.out.println("Client connected.");
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            int p = Integer.parseInt(dis.readUTF());
            System.out.println("Expecting " + p + " frames.");

            for (int i = 0; i < p; i++) {
                String str = dis.readUTF();
                System.out.println("Frame " + i + " is " + str);
                dos.writeUTF("Ack");
            }
            System.out.println("All ACKs sent.");

            dos.close();
            dis.close();
            s.close();
            sr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}