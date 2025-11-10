package UDPServerClient3;

import java.net.*;  
import java.util.*; 
public class Client { 
  public static void main(String[] a)throws Exception{ 
    DatagramSocket s=new DatagramSocket(); 
    System.out.println("UDP Client:");
    InetAddress ip=InetAddress.getByName("localhost"); 
    Scanner sc=new Scanner(System.in); 
    byte[] b=new byte[1024]; 
    while(true){ 
      String msg=sc.nextLine(); 
      s.send(new DatagramPacket(msg.getBytes(),msg.length(),ip,9876)); 
      if(msg.equalsIgnoreCase("bye"))break; 
      DatagramPacket p=new DatagramPacket(b,b.length); s.receive(p); 
      String r=new String(p.getData(),0,p.getLength()); 
      System.out.println("Server: "+r); 
      if(r.equalsIgnoreCase("bye"))break; 
    } s.close(); 
  } 
}