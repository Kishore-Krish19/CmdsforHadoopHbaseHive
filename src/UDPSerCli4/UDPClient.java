/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDPSerCli4;

import java.net.*; 
public class UDPClient { 
    public static void main(String[] args) throws Exception { 
        DatagramSocket socket = new DatagramSocket(); 
        InetAddress ip = InetAddress.getByName("localhost");  
        String msg = "Hello Server"; 
        byte[] sendData = msg.getBytes(); 
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, 8888); 
        socket.send(sendPacket); 
        byte[] buffer = new byte[100]; 
        DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length); 
        socket.receive(receivePacket); 
        String reply = new String(receivePacket.getData(), 0, receivePacket.getLength()); 
        System.out.println("Server: " + reply); 
 
        socket.close(); 
    } 
}