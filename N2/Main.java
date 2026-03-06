package N2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        Graph g = new Graph(v);

        System.out.println("Enter edges (src dest cost)");

        for(int i=0;i<e;i++){

            String s = sc.next();
            String d = sc.next();
            int c = sc.nextInt();

            g.addEdge(s,d,c);
        }

        if(g.isComplete())
            System.out.println("Graph is Complete");
        else
            System.out.println("Graph is NOT Complete");

        System.out.println("Select Algorithm");
        System.out.println("1. Kruskal");
        System.out.println("2. Prim");

        int choice = sc.nextInt();

        if(choice == 1){

            Kruskal k = new Kruskal();
            k.findMST(g);

        }
        else{

            System.out.print("Enter Start Vertex: ");
            String start = sc.next();

            Prim p = new Prim();
            p.findMST(g,start);
        }

        sc.close();
    }
}
