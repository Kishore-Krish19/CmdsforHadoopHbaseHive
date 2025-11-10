/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP17;

import java.io.*; 
import java.net.*; 
import java.util.Scanner;
 
public class TCPClient { 
    public static void main(String[] args) { 
        try { 
            Socket socket = new Socket("localhost", 5000); 
            System.out.println("Connected to server."); 
            System.out.println("Enter File to Send:");
            Scanner s=new Scanner(System.in);
            String f=s.nextLine();
            File file = new File(f); 
            if (!file.exists()) { 
                System.out.println("File not found: " + file.getAbsolutePath()); 
                socket.close(); 
                return; 
            } 
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); 
            FileInputStream fis = new FileInputStream(file); 
            dos.writeUTF(file.getName());  
            byte[] buffer = new byte[4096]; 
            int bytesRead; 
            while ((bytesRead = fis.read(buffer)) > 0) { 
                dos.write(buffer, 0, bytesRead); 
            } 
            System.out.println("File sent successfully!"); 
            fis.close(); 
            dos.close(); 
            socket.close(); 
        } catch (Exception e) { 
            System.out.println("Error: " + e.getMessage()); 
        } 
    } 
}