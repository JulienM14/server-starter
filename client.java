import java.io.*;
import java.net.*;
import java.util.*;
class Client {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(args[0], 7777);
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataIn = new DataInputStream(socket.getInputStream());
            while (true) {
                System.out.print("Type a message > ");
                String userInput = input.nextLine();
                dout.writeUTF(userInput);
                String recieved = (String) dataIn.readUTF();
                System.out.println(recieved);
                dout.flush();
                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }
            }
            dout.close();
            socket.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}