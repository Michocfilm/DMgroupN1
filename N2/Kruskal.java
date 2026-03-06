package N2;

import java.util.*;

public class Kruskal {

    public void findMST(Graph g){

        ArrayList<Edge> edges = g.edges;

        edges.sort(Comparator.comparingInt(e -> e.cost));

        int totalCost = 0;

        System.out.println("Minimum Spanning Tree:");

        for(Edge e : edges){

            System.out.println(e.src + " - " + e.dest + " : " + e.cost);

            totalCost += e.cost;

            if(totalCost > 0 && totalCost >= g.vertices-1)
                break;
        }

        System.out.println("Total Cost: " + totalCost);
    }

}
