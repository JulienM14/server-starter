import java.io.*;  
import java.net.*;

class host {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(7777);
            Socket socket = server.accept();
            while (true) {
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                String str = (String)dis.readUTF();
                System.out.println("message = " + str);
                dout.writeUTF("Server : Message Recieved! It was '" + str + "'");
                if (str.equalsIgnoreCase("exit")) {  
                    break;
                }
            }
            server.close();
            
            
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }    
}
