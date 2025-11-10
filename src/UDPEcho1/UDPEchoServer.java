package UDPEcho1;

import java.net.*; 
public class UDPEchoServer { 
    public static void main(String[] args) throws Exception { 
        DatagramSocket socket = new DatagramSocket(9876); 
        byte[] buf = new byte[1024]; 
        System.out.println("Server running..."); 
        while (true) { 
            DatagramPacket pkt = new DatagramPacket(buf, buf.length); 
            socket.receive(pkt); 
            String msg = new String(pkt.getData(), 0, pkt.getLength()); 
            System.out.println("From client: " + msg); 
            socket.send(new DatagramPacket(msg.getBytes(), msg.length(), 
                    pkt.getAddress(), pkt.getPort())); 
            if (msg.equalsIgnoreCase("bye")) break; 
        } 
        socket.close(); 
    } 
}