import java.util.Arrays;

public class Dijkstra {

    public static void run(int[][] graph, int start) {
        int v = graph.length;
        int[] dist = new int[v];
        boolean[] visited = new boolean[v];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < v - 1; i++) {
            int u = -1;
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < v; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }

            visited[u] = true;

            for (int j = 0; j < v; j++) {
                if (graph[u][j] != 0 && !visited[j]) {
                    if (dist[u] + graph[u][j] < dist[j]) {
                        dist[j] = dist[u] + graph[u][j];
                    }
                }
            }
        }

        System.out.println("\nShortest Path (Dijkstra):");
        for (int i = 0; i < v; i++) {
            System.out.println(start + " → " + i + " = " + dist[i]);
        }
    }
}