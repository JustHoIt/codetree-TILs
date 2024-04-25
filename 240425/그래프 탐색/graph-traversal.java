import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 1000;
    public static int n, m;
    public static int[][] graph = new int[MAX_NUM + 1][MAX_NUM + 1];
    public static boolean[] visited = new boolean[MAX_NUM + 1];
    public static int vertexCnt = 0;

    public static void DFS(int vertex) {
        for(int currV = 1; currV <= n; currV++) {
            if(graph[vertex][currV] == 1 && !visited[currV]) {
                visited[currV] = true;
                vertexCnt++;
                DFS(currV);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        while(m-- > 0) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
       
        visited[1] = true;
        DFS(1);

        System.out.println(vertexCnt);
    }
}