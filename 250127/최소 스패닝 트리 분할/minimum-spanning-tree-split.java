import java.util.Scanner;
import java.util.Arrays;

class Tuple implements Comparable<Tuple> {
    int x, y, cost;

    public Tuple(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Tuple t) {
        return this.cost - t.cost;
    }
}

public class Main {
    public static final int MAX_M = 100000;
    public static final int MAX_N = 10000;
    public static int n, m;
    public static Tuple[] edges = new Tuple[MAX_M + 1];
    public static int[] uf = new int[MAX_N + 1];
    public static int find(int x) {
        if(uf[x] == x) {
            return x;
        }
        return uf[x] = find(uf[x]);
    }
    
    public static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);
        uf[X] = Y;
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int cost = sc.nextInt();

            edges[i] = new Tuple(x, y, cost);
        }

        Arrays.sort(edges, 1, m + 1);

        for(int i = 1; i <= n; i++) {
            uf[i] = i;
        }

        int ans = 0;
        int lastCost = 0; 
        for(int i = 1; i <= m; i++) {
            int x = edges[i].x;
            int y = edges[i].y;
            int cost = edges[i].cost;

            if(find(x) != find(y)) {
                ans += cost;
                lastCost = cost;
                union(x, y);
            }
        }

        System.out.print(ans - lastCost);
    }
}
