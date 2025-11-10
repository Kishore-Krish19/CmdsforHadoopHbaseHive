/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Broadcaster8;
import java.util.*;
import java.net.*; 
public class Broadcaster { 
    public static void main(String[] args) throws Exception { 
        try (DatagramSocket socket = new DatagramSocket()) {
            socket.setBroadcast(true);
            System.out.println("Enter the message to Broadcast:");
            Scanner s=new Scanner(System.in);
            String msg = s.nextLine();
            DatagramPacket packet = new DatagramPacket(
                    msg.getBytes(), msg.length(),
                    InetAddress.getByName("255.255.255.255"), 9876);
            socket.send(packet);
            System.out.println("Broadcast message sent.");
        } 
    } 
} 