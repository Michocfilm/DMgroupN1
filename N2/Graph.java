package N2;

import java.util.*;

public class Graph {

    int vertices;
    ArrayList<Edge> edges;

    public Graph(int v){
        vertices = v;
        edges = new ArrayList<>();
    }

    public void addEdge(int from,int to,int cost){
        edges.add(new Edge(from,to,cost));
    }

    public boolean isCompleteGraph(){

        int expected = vertices*(vertices-1)/2;

        return edges.size() == expected;
    }
}