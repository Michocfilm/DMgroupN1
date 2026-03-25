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

        System.out.println();
        System.out.println("=== Graph Summary ===");
        System.out.println("Vertices = " + graph.getVertexCount());
        System.out.println("Edges = " + graph.getEdgeCount());

        if (graph.isCompleteGraph()) {
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
                runKruskal(graph);
                break;

            case 2:
                runPrim(graph, input);
                break;

            case 3:
                runDijkstra(graph, input);
                break;

            default:
                System.out.println("Invalid algorithm choice.");
        }

        input.close();
    }

    private static Graph loadTestCase(Scanner input) {
        System.out.println();
        System.out.println("Choose test case:");
        System.out.println("1 = 4 vertices, 5 edges");
        System.out.println("2 = Complete graph (3 vertices)");
        System.out.println("3 = Dijkstra sample (5 vertices)");
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

    private static Graph readGraphFromKeyboard(Scanner input) {
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

    private static void runKruskal(Graph graph) {
        System.out.println();
        System.out.println("=== Kruskal MST ===");

        Kruskal kruskal = new Kruskal(graph);
        kruskal.findMinimumSpanningTree();
    }

    private static void runPrim(Graph graph, Scanner input) {
        System.out.println();
        System.out.println("=== Prim MST ===");
        System.out.print("Enter start vertex: ");
        int startVertex = input.nextInt();

        Prim prim = new Prim(graph);
        prim.findMinimumSpanningTree(startVertex);
    }

    private static void runDijkstra(Graph graph, Scanner input) {
        System.out.println();
        System.out.println("=== Dijkstra Shortest Path ===");
        System.out.print("Enter start vertex: ");
        int startVertex = input.nextInt();

        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.findShortestPath(startVertex);
    }
}