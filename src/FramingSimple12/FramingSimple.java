/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FramingSimple12;

import java.util.*; 
public class FramingSimple { 
public static void main(String args[]) { 
Scanner sc = new Scanner(System.in); 
System.out.print("Enter Data: "); 
String data = sc.nextLine(); 
// Character Count 
String cc = (data.length() + 1) + data; 
        // Character Stuffing (Flag = F, ESC = E) 
        String cs = data.replace("E","EE").replace("F","EF"); 
        cs = "F" + cs + "F"; 
        // Bit Stuffing 
        String bs = ""; 
        int count = 0; 
        for(char c : data.toCharArray()) { 
            bs += c; 
            if(c=='1') count++; 
            else count = 0; 
            if(count==5){ 
                bs += "0"; 
                count = 0; 
            } 
        } 
        System.out.println("\nCharacter Count: " + cc); 
        System.out.println("Character Stuffing: " + cs); 
        System.out.println("Bit Stuffing: " + bs); 
    } 
}