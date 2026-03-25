import java.util.ArrayList;

public class Graph {
    int vertices;
    ArrayList<Edge> edges;

    public Graph(int v) {
        vertices = v;
        edges = new ArrayList<>();
    }

    public void addEdge(int u, int v, int w) {
        edges.add(new Edge(u, v, w));
    }

    public boolean isComplete() {
        return edges.size() == (vertices * (vertices - 1)) / 2;
    }
}