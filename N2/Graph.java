package N2;

import java.util.ArrayList;

public class Graph {

    int vertices;
    ArrayList<Edge> edges = new ArrayList<>();

    public Graph(int vertices){
        this.vertices = vertices;
    }

    public void addEdge(String s, String d, int c){
        edges.add(new Edge(s,d,c));
    }

    public boolean isComplete(){

        int n = vertices;
        int maxEdges = n*(n-1)/2;

        return edges.size() == maxEdges;
    }

}