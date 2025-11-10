/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IProuting9;

import java.util.*; 
class IPRouting { 
    public static void main(String[] a) { 
        Scanner s = new Scanner(System.in); 
        String[][] table = { 
            {"192.168.1", "Router A"}, 
            {"192.168.2", "Router B"}, 
            {"10.0.0",    "Router C"} 
        }; 
        System.out.print("Enter destination IP: "); 
        String ip = s.next(); 
        for (String[] t : table) 
            if (ip.startsWith(t[0])) { 
                System.out.println("Routed via " + t[1]); 
                return; 
} 
System.out.println("No route found."); 
} 
} 