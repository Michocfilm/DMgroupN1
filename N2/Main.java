// File: Main.java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Graph Program ===");
        System.out.println("Choose input mode:");
        System.out.println("1 = Use built-in test case");
        System.out.println("2 = Enter graph manually");
        System.out.print("Your choice: ");
        int inputMode = input.nextInt();

        Graph graph;

        if (inputMode == 1) {
            graph = loadTestCase(input);
        } else if (inputMode == 2) {
            graph = readGraphFromKeyboard(input);
        } else {
            System.out.println("Invalid input mode.");
            input.close();
            return;
        }

        int[][] matrix = buildAdjacencyMatrix(graph);

        System.out.println();
        System.out.println("=== Graph Summary ===");
        System.out.println("Vertices = " + graph.vertices);
        System.out.println("Edges = " + graph.edges.size());

        if (graph.isComplete()) {
            System.out.println("Graph is a Complete Graph");
        } else {
            System.out.println("Graph is NOT a Complete Graph");
        }

        System.out.println();
        System.out.println("Choose algorithm:");
        System.out.println("1 = Kruskal MST");
        System.out.println("2 = Prim MST");
        System.out.println("3 = Dijkstra Shortest Path");
        System.out.print("Your choice: ");
        int algorithmChoice = input.nextInt();

        switch (algorithmChoice) {
            case 1:
                System.out.println();
                System.out.println("=== Kruskal MST ===");
                Kruskal.run(graph);
                break;

            case 2:
                System.out.println();
                System.out.println("=== Prim MST ===");
                System.out.print("Enter start vertex: ");
                int primStart = input.nextInt();
                Prim.run(matrix, primStart);
                break;

            case 3:
                System.out.println();
                System.out.println("=== Dijkstra Shortest Path ===");
                System.out.print("Enter start vertex: ");
                int dijkstraStart = input.nextInt();
                Dijkstra.run(matrix, dijkstraStart);
                break;

            default:
                System.out.println("Invalid algorithm choice.");
        }

        input.close();
    }

    static Graph loadTestCase(Scanner input) {
        System.out.println();
        System.out.println("Choose test case:");
        System.out.println("1 = MST sample");
        System.out.println("2 = Complete graph sample");
        System.out.println("3 = Dijkstra sample");
        System.out.print("Your choice: ");
        int testCaseChoice = input.nextInt();

        Graph graph;

        switch (testCaseChoice) {
            case 1:
                graph = new Graph(4);
                graph.addEdge(0, 1, 4);
                graph.addEdge(0, 2, 3);
                graph.addEdge(1, 2, 1);
                graph.addEdge(1, 3, 2);
                graph.addEdge(2, 3, 5);
                break;

            case 2:
                graph = new Graph(3);
                graph.addEdge(0, 1, 1);
                graph.addEdge(1, 2, 2);
                graph.addEdge(0, 2, 3);
                break;

            case 3:
                graph = new Graph(5);
                graph.addEdge(0, 1, 10);
                graph.addEdge(0, 2, 5);
                graph.addEdge(1, 3, 1);
                graph.addEdge(2, 1, 3);
                graph.addEdge(2, 3, 8);
                graph.addEdge(3, 4, 2);
                break;

            default:
                System.out.println("Invalid test case. Using default test case 1.");
                graph = new Graph(4);
                graph.addEdge(0, 1, 4);
                graph.addEdge(0, 2, 3);
                graph.addEdge(1, 2, 1);
                graph.addEdge(1, 3, 2);
                graph.addEdge(2, 3, 5);
                break;
        }

        return graph;
    }

    static Graph readGraphFromKeyboard(Scanner input) {
        System.out.print("Enter number of vertices: ");
        int vertexCount = input.nextInt();

        System.out.print("Enter number of edges: ");
        int edgeCount = input.nextInt();

        Graph graph = new Graph(vertexCount);

        System.out.println("Enter each edge in format: u v weight");
        for (int i = 0; i < edgeCount; i++) {
            System.out.print("Edge " + (i + 1) + ": ");
            int fromVertex = input.nextInt();
            int toVertex = input.nextInt();
            int weight = input.nextInt();
            graph.addEdge(fromVertex, toVertex, weight);
        }

        return graph;
    }

    static int[][] buildAdjacencyMatrix(Graph graph) {
        int[][] matrix = new int[graph.vertices][graph.vertices];

        for (Edge edge : graph.edges) {
            matrix[edge.from][edge.to] = edge.cost;
            matrix[edge.to][edge.from] = edge.cost;
        }

        return matrix;
    }
}