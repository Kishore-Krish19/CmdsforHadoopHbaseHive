package UDPSerCli4;

import java.net.*; 
public class UDPServer { 
    public static void main(String[] args) throws Exception { 
        DatagramSocket socket = new DatagramSocket(8888); 
        byte[] buffer = new byte[100]; 
        System.out.println("Server started. Waiting for client..."); 
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length); 
        socket.receive(packet); 
        String msg = new String(packet.getData(), 0, packet.getLength()); 
        System.out.println("Client: " + msg); 
        String reply = "Hello Client"; 
        byte[] sendData = reply.getBytes(); 
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, 
packet.getAddress(), packet.getPort()); 
        socket.send(sendPacket); 
        System.out.println("Reply sent to client."); 
        socket.close(); 
    } 
}