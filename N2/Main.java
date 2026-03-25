import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Vertices: ");
        int v = sc.nextInt();

        System.out.print("Edges: ");
        int e = sc.nextInt();

        Graph g = new Graph(v);
        int[][] matrix = new int[v][v];

        System.out.println("Enter edges (u v cost):");
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            g.addEdge(a, b, c);
            matrix[a][b] = c;
            matrix[b][a] = c;
        }

        System.out.println("\n1. Check Complete");
        System.out.println("2. Kruskal");
        System.out.println("3. Prim");
        System.out.println("4. Shortest Path");

        int choice = sc.nextInt();

        if (g.isComplete())
            System.out.println("Graph is Complete Graph");
        else
            System.out.println("Graph is NOT Complete");

        switch (choice) {
            case 2:
                Kruskal.run(g);
                break;
            case 3:
                System.out.print("Start vertex: ");
                int s = sc.nextInt();
                Prim.run(matrix, s);
                break;
            case 4:
                System.out.print("Start vertex: ");
                int d = sc.nextInt();
                Dijkstra.run(matrix, d);
                break;
        }
    }
}