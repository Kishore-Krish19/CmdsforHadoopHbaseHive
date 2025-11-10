/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sliding7;

import java.util.*; 
class SlidingWindow { 
    public static void main(String[] args) { 
        Scanner s = new Scanner(System.in); 
        int w = 5, total; 
        System.out.print("Enter total frames: "); 
        total = s.nextInt(); 
        for (int i = 1; i <= total; i += w) { 
            System.out.print("\nSending frames: "); 
            for (int j = i; j < i + w && j <= total; j++) 
                System.out.print(j + " "); 
            System.out.print("\nAll acknowledged."); 
        } 
        System.out.println("\n\nAll frames sent!"); 
    } 
} 