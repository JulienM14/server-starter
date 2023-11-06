import java.io.*;  
import java.net.*;  

class host {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(7777);
            Socket socket = server.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String str = (String)dis.readUTF();
            System.out.println("message = " + str);
            server.close();  
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }    
}
