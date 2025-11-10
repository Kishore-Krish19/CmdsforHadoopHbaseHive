/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datagramsocket14;

import java.net.*; 
 
public class Client { 
    public static void main(String[] args) throws Exception { 
        try (DatagramSocket client = new DatagramSocket(6000)) {
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            
            System.out.println("Client waiting for messages...");
            while (true) {
                client.receive(packet);
                String msg = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Server: " + msg);
                if (msg.equalsIgnoreCase("bye")) break;
            }
        } 
    } 
}