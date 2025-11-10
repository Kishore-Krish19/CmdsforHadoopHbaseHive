/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datagramsocket14;

import java.net.*; 
import java.io.*; 
public class Server { 
public static void main(String[] args) throws Exception { 
    try (DatagramSocket server = new DatagramSocket(5000)) {
        BufferedReader br = new BufferedReader(new
        java.io.InputStreamReader(System.in));
        InetAddress clientIP = InetAddress.getLocalHost();
        System.out.println("Server ready. Type messages to send:");
        while (true) {
            String msg = br.readLine();
            byte[] data = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, clientIP, 6000);
            server.send(packet);
            if (msg.equalsIgnoreCase("bye")) break;
        }
    } 
    } 
}