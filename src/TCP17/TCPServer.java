/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP17;

import java.io.*; 
import java.net.*; 
 
public class TCPServer { 
    public static void main(String[] args) { 
        try { 
            ServerSocket serverSocket = new ServerSocket(5000); 
            System.out.println("Server started. Waiting for client connection..."); 
            Socket socket = serverSocket.accept(); 
            System.out.println("Client connected."); 
            DataInputStream dis = new DataInputStream(socket.getInputStream()); 
            String fileName = dis.readUTF();  
            File receivedFile = new File("received_" + fileName); 
            FileOutputStream fos = new FileOutputStream(receivedFile); 
            byte[] buffer = new byte[4096]; 
            int bytesRead; 
            while ((bytesRead = dis.read(buffer)) > 0) { 
                fos.write(buffer, 0, bytesRead); 
            } 
            System.out.println("File received successfully!"); 
            System.out.println("Saved as: " + receivedFile.getAbsolutePath()); 
            fos.close(); 
            dis.close(); 
            socket.close(); 
            serverSocket.close(); 
        } catch (Exception e) { 
            System.out.println("Error: " + e.getMessage()); 
        } 
    } 
}