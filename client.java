import java.io.*;
import java.net.*;


class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 7777);
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            dout.writeUTF("hello!");
            dout.flush();
            dout.close();
            socket.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}