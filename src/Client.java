import java.util.*;
import java.net.*;
import java.io.*;
public class Client {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String server = args[0];
        int port = Integer.parseInt(args[1]);
        System.out.print("Enter message: ");
        String message = input.nextLine();
        if(message != null || message.equals("")) {
            Socket connect = new Socket(server, port);
            connect.setTcpNoDelay(true);
            connect.setSoTimeout(0);
            OutputStream out = connect.getOutputStream();
            DataOutputStream send = new DataOutputStream(out);
            send.write(Base64.getEncoder().encode(message.getBytes()));
            send.flush();
            connect.close();
        } else {
            System.err.println("Error: Message is either blank or null.");
        }
    }
}
