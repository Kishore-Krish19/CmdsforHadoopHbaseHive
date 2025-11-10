/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DistanceVector19;

import java.util.*;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        int[][] cost = new int[n][n];
        System.out.println("Enter cost matrix (use 999 for infinity):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        int[][] distance = new int[n][n];
        int[][] nextHop = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = cost[i][j];
                nextHop[i][j] = j;
            }
        }

        // Distance Vector algorithm 
        boolean updated;
        do {
            updated = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (distance[i][j] > cost[i][k] + distance[k][j]) {
                            distance[i][j] = cost[i][k] + distance[k][j];
                            nextHop[i][j] = k;
                            updated = true;
                        }
                    }
                }
            }
        } while (updated);

        System.out.println("\nFinal Distance Vector Table:");
        for (int i = 0; i < n; i++) {
            System.out.println("Router " + i + ":");
            for (int j = 0; j < n; j++) {
                System.out.println(" -> To " + j + " via " + nextHop[i][j] + " distance " + distance[i][j]);
            }
            System.out.println();
        }

        // Example path from client to server 
        System.out.print("Enter source node: ");
        int src = sc.nextInt();
        System.out.print("Enter destination node: ");
        int dest = sc.nextInt();

        System.out.print("Path: " + src);
        while (src != dest) {
            src = nextHop[src][dest];
            System.out.print(" -> " + src);
        }
        System.out.println();
        sc.close();
    }
}
/*
Enter number of nodes: 3
Enter cost matrix (use 999 for infinity):
0 2
999
2 0 3
999 3 0

Final Distance Vector Table:
Router 0:
 -> To 0 via 0 distance 0
 -> To 1 via 1 distance 2
 -> To 2 via 1 distance 5

Router 1:
 -> To 0 via 0 distance 2
 -> To 1 via 1 distance 0
 -> To 2 via 2 distance 3

Router 2:
 -> To 0 via 1 distance 5
 -> To 1 via 1 distance 3
 -> To 2 via 2 distance 0

Enter source node: 0
Enter destination node: 2
Path: 0 -> 1 -> 2
*/