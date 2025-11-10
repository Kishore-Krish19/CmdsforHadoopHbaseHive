/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PathVectorRouting16;

import java.util.*;

public class PathVectorRouting {

    static class Route {

        String dest;
        List<String> path;
        int cost;

        Route(String d, List<String> p, int c) {
            dest = d;
            path = new ArrayList<>(p);
            cost = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Routers: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline 
        Map<String, List<Route>> table = new HashMap<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Router name: ");
            table.put(sc.nextLine(), new ArrayList<>());
        }
        System.out.print("Connections: ");
        int c = sc.nextInt();
        for (int i = 0; i < c; i++) {
            System.out.print("Src Dest Cost: ");
            String s = sc.next();
            String d = sc.next();
            int cost = sc.nextInt();
            table.get(s).add(new Route(d, Arrays.asList(s, d), cost));
            table.get(d).add(new Route(s, Arrays.asList(d, s), cost));
        }

        System.out.println("\n--- Path Vector Table ---");
        table.forEach((r, routes) -> {
            System.out.println("\nRouter: " + r);
            routes.forEach(rt
                    -> System.out.println("To " + rt.dest + " via " + rt.path + " cost=" + rt.cost)
            );
        });
        sc.close();
    }
}
/*
Routers: 3
Router name: A
Router name: B
Router name: C
Connections: 3
Src Dest Cost: A B 2
Src Dest Cost: B C 3
Src Dest Cost: C A 5

--- Path Vector Table ---

Router: A
To B via [A, B] cost=2
To C via [A, C] cost=5

Router: B
To A via [B, A] cost=2
To C via [B, C] cost=3

Router: C
To B via [C, B] cost=3
To A via [C, A] cost=5
*/