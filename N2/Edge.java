package N2;
public class Edge implements Comparable<Edge>{

    int from;
    int to;
    int cost;

    public Edge(int from,int to,int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge other){
        return this.cost - other.cost;
    }
}