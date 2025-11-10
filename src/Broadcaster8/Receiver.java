/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Broadcaster8;

import java.net.*; 
public class Receiver { 
public static void main(String[] args) throws Exception { 
DatagramSocket socket = new DatagramSocket(9876); 
byte[] buffer = new byte[1024]; 
DatagramPacket packet = new DatagramPacket(buffer, buffer.length); 
System.out.println("Waiting for broadcast..."); 
socket.receive(packet); 
System.out.println("Received: " + new String(packet.getData()).trim()); 
socket.close(); 
} 
}