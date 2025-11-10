/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PingShort13;

public class PingShort { 
    public static void main(String[] args) { 
        int nodes = 6; 
        int bufferLimit = 3; 
        int packets = 10; 
        int dropped = 0; 
 
        for(int p=1; p<=packets; p++) { 
            int load = (int)(Math.random()*5); // random traffic load 
            if(load > bufferLimit) 
                dropped++; 
        } 
 
        System.out.println("Total Packets Sent : " + packets); 
        System.out.println("Packets Dropped    : " + dropped); 
    } 
} 
