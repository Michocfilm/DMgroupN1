public class Prim {

    public static void run(int[][] graph, int start) {
        int v = graph.length;
        boolean[] visited = new boolean[v];
        visited[start] = true;

        int total = 0;

        System.out.println("\nMST (Prim):");

        for (int count = 0; count < v - 1; count++) {
            int min = Integer.MAX_VALUE;
            int x = 0, y = 0;

            for (int i = 0; i < v; i++) {
                if (visited[i]) {
                    for (int j = 0; j < v; j++) {
                        if (!visited[j] && graph[i][j] != 0 && graph[i][j] < min) {
                            min = graph[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }

            System.out.println(x + " - " + y + " : " + min +
                    " (เลือก edge ที่เล็กสุด)");
            visited[y] = true;
            total += min;
        }

        System.out.println("Total cost = " + total);
    }
}