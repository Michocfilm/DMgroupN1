package N2;

import java.util.*;

public class Prim {

    public void findMST(Graph g, String start){

        System.out.println("Prim Algorithm starting from: " + start);

        int totalCost = 0;

        for(Edge e : g.edges){

            System.out.println(e.src + " - " + e.dest + " : " + e.cost);

            totalCost += e.cost;
        }

        System.out.println("Total Cost: " + totalCost);
    }

}
