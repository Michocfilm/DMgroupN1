package N2;

public class Prim {

    public static void run(int[][] graph,int start){

        int v = graph.length;

        boolean visited[] = new boolean[v];

        visited[start] = true;

        int edgeCount = 0;
        int totalCost = 0;

        System.out.println("Spanning Tree (Prim)");

        while(edgeCount < v-1){

            int min = Integer.MAX_VALUE;

            int x = 0;
            int y = 0;

            for(int i=0;i<v;i++){

                if(visited[i]){

                    for(int j=0;j<v;j++){

                        if(!visited[j] && graph[i][j]!=0){

                            if(graph[i][j] < min){

                                min = graph[i][j];
                                x = i;
                                y = j;

                            }
                        }
                    }
                }
            }

            System.out.println(x+" - "+y+" : "+graph[x][y]);

            totalCost += graph[x][y];

            visited[y] = true;

            edgeCount++;
        }

        System.out.println("Total cost = "+totalCost);
    }
}