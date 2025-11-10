package datagramchat2; 
import java.net.*; 
public class Client { 
    public static void main(String[] args) throws Exception { 
        DatagramSocket s = new DatagramSocket(9877); 
        byte[] buf = new byte[1024]; 
        System.out.println("Client waiting for messages..."); 
        while (true) { 
            DatagramPacket p = new DatagramPacket(buf, buf.length); 
            s.receive(p); 
            String msg = new String(p.getData(), 0, p.getLength()); 
            System.out.println("From Server: " + msg); 
            if (msg.equalsIgnoreCase("bye")) break; 
        } 
        s.close(); 
    } 
} 