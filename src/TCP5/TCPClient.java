/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP5;
import java.io.*; 
import java.net.*; 
public class TCPClient { 
public static void main(String[] a)throws Exception{ 
    try (Socket s = new Socket("localhost",8088)) {
        BufferedReader kb=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(s.getOutputStream(),true);
        BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.print("Enter file name: ");
        out.println(kb.readLine());
        String line;
        while((line=in.readLine())!=null) System.out.println(line);
    } 
} 
} 