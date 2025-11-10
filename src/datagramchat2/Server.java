package datagramchat2;

import java.net.*; 
import java.util.*; 
public class Server { 
    public static void main(String[] args) throws Exception { 
        DatagramSocket s = new DatagramSocket(); 
        InetAddress ip = InetAddress.getByName("localhost"); 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Server started, type messages:"); 
        while (true) { 
            String msg = sc.nextLine(); 
            byte[] buf = msg.getBytes(); 
            s.send(new DatagramPacket(buf, buf.length, ip, 9877)); 
            if (msg.equalsIgnoreCase("bye")) break; 
        } 
        s.close(); 
    } 
}