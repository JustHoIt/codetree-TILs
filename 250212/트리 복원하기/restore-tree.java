import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Tuple implements Comparable<Tuple> {
    int a, b, w;

    public Tuple(int a, int b, int w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }

    @Override
    public int compareTo(Tuple t) {
        if(this.a != t.a) {
            return this.a - t.a;
        }

        if(this.b != t.b) {
            return this.b - t.b; 
        }

        return this.w - t.w;    
    }
}

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 500;
    public static int n, m;
    public static int[][] graph = new int[MAX_N + 1][MAX_N + 1];
    public static int[] dist = new int[MAX_N + 1];
    public static int[] distFrom = new int[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static ArrayList<Tuple> mstEdges = new ArrayList<>();

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i <= n; i++) {
            dist[i] = (int)1e9;
        }

        dist[1] = 0;

        for(int i = 1; i <= n; i++) {
            int minIndex = -1;
            for(int j = 1; j <= n; j++) {
                if(visited[j]) {
                    continue;
                }
                
                if(minIndex == -1 || dist[minIndex] > dist[j]) {
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            if(minIndex != 1) {
                mstEdges.add(new Tuple(
                    Math.min(minIndex, distFrom[minIndex]), 
                    Math.max(minIndex, distFrom[minIndex]), 
                    dist[minIndex]
                ));
            }

            for(int j = 1; j <= n; j++) {
                if(graph[minIndex][j] == 0) {
                    continue;
                }

                if(dist[j] > graph[minIndex][j]) {
                    dist[j] = graph[minIndex][j];
                    distFrom[j] = minIndex;
                }
            }
        }

        Collections.sort(mstEdges);

        for(int i = 0; i < mstEdges.size(); i++) {
            int a = mstEdges.get(i).a;
            int b = mstEdges.get(i).b;
            int w = mstEdges.get(i).w;

            System.out.println(a + " " + b + " " + w);
        }
    }
}
