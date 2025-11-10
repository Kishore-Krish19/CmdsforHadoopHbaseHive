package UDPEcho1;

import java.net.*;  
import java.util.*; 
public class UDPEchoClient { 
    public static void main(String[] args) throws Exception { 
        DatagramSocket socket = new DatagramSocket(); 
        InetAddress ip = InetAddress.getByName("localhost"); 
        Scanner sc = new Scanner(System.in); 
        byte[] buf = new byte[1024]; 
        System.out.println("Client started. Type messages:"); 
        while (true) { 
            String msg = sc.nextLine(); 
            socket.send(new DatagramPacket(msg.getBytes(), msg.length(), ip, 9876)); 
            if (msg.equalsIgnoreCase("bye")) break; 
            DatagramPacket pkt = new DatagramPacket(buf, buf.length); 
            socket.receive(pkt); 
            System.out.println("Echo: " + new String(pkt.getData(), 0, pkt.getLength())); 
        } 
        socket.close(); 
    } 
} 