package N2;

import java.util.*;

public class Kruskal {

    static int find(int parent[],int x){

        if(parent[x]==x)
            return x;

        return parent[x] = find(parent,parent[x]);
    }

    static void union(int parent[],int a,int b){

        int rootA = find(parent,a);
        int rootB = find(parent,b);

        parent[rootA] = rootB;
    }

    public static void run(Graph g){

        Collections.sort(g.edges);

        int parent[] = new int[g.vertices];

        for(int i=0;i<g.vertices;i++)
            parent[i]=i;

        int totalCost = 0;

        System.out.println("Spanning Tree (Kruskal)");

        for(Edge e : g.edges){

            int r1 = find(parent,e.from);
            int r2 = find(parent,e.to);

            if(r1 != r2){

                System.out.println(e.from+" - "+e.to+" : "+e.cost);

                totalCost += e.cost;

                union(parent,r1,r2);
            }
        }

        System.out.println("Total cost = "+totalCost);
    }
}