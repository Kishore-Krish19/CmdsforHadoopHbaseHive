package UDPServerClient3;

import java.util.*; 
import java.net.*;  

public class Server { 
  public static void main(String[] a)throws Exception{ 
    DatagramSocket s=new DatagramSocket(9876); 
    Scanner sc=new Scanner(System.in); 
    byte[] b=new byte[1024]; 
    System.out.println("UDP Server:\n Type (bye) to end:");
    while(true){ 
      DatagramPacket p=new DatagramPacket(b,b.length); s.receive(p); 
      String msg=new String(p.getData(),0,p.getLength()); 
      System.out.println("Client: "+msg); 
      if(msg.equalsIgnoreCase("bye"))break; 
      String r=sc.nextLine(); 
      s.send(new DatagramPacket(r.getBytes(),r.length(),p.getAddress(),p.getPort())); 
      if(r.equalsIgnoreCase("bye"))break; 
    } s.close(); 
  } 
} 