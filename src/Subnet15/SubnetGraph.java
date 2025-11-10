/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subnet15;

import java.util.*;

public class SubnetGraph {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of subnet nodes: ");
        int n = sc.nextInt(), delay[][] = new int[n][n];
        System.out.print("Enter number of links: ");
        int e = sc.nextInt();

        System.out.println("Enter links (src dest delay):");
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), d = sc.nextInt();
            delay[a][b] = delay[b][a] = d;
        }

        System.out.println("Delay (in ms) between nodes:");
        for (int[] row : delay) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }

        System.out.print("\nEnter source node to find minimum delay: ");
        int src = sc.nextInt();
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(dist, 9999);
        dist[src] = 0;

        for (int c = 0; c < n - 1; c++) {
            int u = -1, min = 9999;
            for (int i = 0; i < n; i++) {
                if (!vis[i] && dist[i] < min) {
                    min = dist[i];
                    u = i;
                }
            }
            vis[u] = true;
            for (int v = 0; v < n; v++) {
                if (!vis[v] && delay[u][v] > 0 && dist[u] + delay[u][v] < dist[v]) {
                    dist[v] = dist[u] + delay[u][v];
                }
            }
        }
        System.out.println("\nMinimum delay from node " + src + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("To node " + i + " = " + dist[i] + " ms");
        }
        sc.close();
    }
}

/*
Enter number of subnet nodes: 5
Enter number of links: 5
Enter links (src dest delay):
1 2 3
2 3 4
1 4 5
3 4 1
4 3 2
Delay (in ms) between nodes:
0	0	0	0	0	
0	0	3	0	5	
0	3	0	4	0	
0	0	4	0	2	
0	5	0	2	0	

Enter source node to find minimum delay: 2

Minimum delay from node 2:
To node 0 = 9999 ms
To node 1 = 3 ms
To node 2 = 0 ms
To node 3 = 4 ms
To node 4 = 6 ms
*/