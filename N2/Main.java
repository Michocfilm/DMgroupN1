package N2;

import java.util.*;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Number of edges: ");
        int e = sc.nextInt();

        Graph g = new Graph(v);

        int[][] matrix = new int[v][v];

        System.out.println("Enter edges (from to cost)");

        for(int i=0;i<e;i++){

            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            g.addEdge(from,to,cost);

            matrix[from][to] = cost;
            matrix[to][from] = cost;
        }

        if(g.isCompleteGraph())
            System.out.println("Graph is Complete Graph");
        else
            System.out.println("Graph is NOT Complete Graph");

        System.out.println();
        System.out.println("Choose Algorithm");
        System.out.println("1 = Kruskal");
        System.out.println("2 = Prim");

        int choice = sc.nextInt();

        if(choice == 1){

            Kruskal.run(g);

        }else if(choice == 2){

            System.out.print("Start vertex: ");
            int start = sc.nextInt();

            Prim.run(matrix,start);
        }

        sc.close();
    }
}