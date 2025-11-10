/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP5;
import java.io.*; 
import java.net.*; 
public class TCPServer { 
  public static void main(String[] a)throws Exception{ 
      System.out.println("TCP Server Started...");
      try (ServerSocket ss = new ServerSocket(8088); Socket s = ss.accept()) {
          BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
          PrintWriter out=new PrintWriter(s.getOutputStream(),true);
          String fname=in.readLine();
          File f=new File(fname);
          if(f.exists()){
              try (BufferedReader fr = new BufferedReader(new FileReader(f))) {
                  String line;
                  while((line=fr.readLine())!=null) out.println(line);
              }
          }else out.println("File not found");
      }
  } 
} 
