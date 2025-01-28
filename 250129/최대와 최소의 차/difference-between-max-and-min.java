import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Tuple implements Comparable<Tuple> {
    int cost, x, y;

    public Tuple(int cost, int x, int y) {
        this.cost = cost;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Tuple t) {
        return this.cost - t.cost;
    }
}

public class Main {
    public static final int MAX_M = 100000;
    public static final int MAX_N = 100000;
    public static int n, m;
    public static ArrayList<Tuple> edges = new ArrayList<>();
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
    
    public static int mst() {
        for(int i = 1; i <= n; i++){
            uf[i] = i;
        }

        int totalCost = 0;

        for(int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).cost;
            int x = edges.get(i).x;
            int y = edges.get(i).y;
            if(find(x) != find(y)) {
                totalCost += cost;
                union(x, y);
            }
        }
    
        return totalCost;
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
            edges.add(new Tuple(1 - cost, x, y));
        }

        Collections.sort(edges);

        int ansMin = mst();

        Collections.sort(edges, Collections.reverseOrder());

        int ansMax = mst();
        
        System.out.print((long)ansMax * ansMax - (long)ansMin * ansMin);
    }
}
