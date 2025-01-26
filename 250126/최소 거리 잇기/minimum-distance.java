import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Pair {
    int x, y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Tuple implements Comparable<Tuple> {
    double dist;
    int x, y;

    public Tuple(double dist, int x, int y) {
        this.dist = dist;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Tuple t) {
        return new Double(this.dist).compareTo(t.dist); // 거리 기준 오름차순 정렬을 진행합니다.
    }
}

public class Main {
    public static final int MAX_N = 200;
    
    // 변수 선언
    public static int n, m;
    public static Pair[] points = new Pair[MAX_N + 1];
    
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

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            points[i] = new Pair(x, y);
        }

        for(int i = 1; i <= n; i++) {
            for(int j = i + 1; j <= n; j++) {
                int x1 = points[i].x;
                int y1 = points[i].y;
                int x2 = points[j].x;
                int y2 = points[j].y;
                double dist = Math.sqrt(
                    (long)(x1 - x2) * (x1 - x2) + (long)(y1 - y2) * (y1 - y2)
                );
                
                edges.add(new Tuple(dist, i, j));
            }
        }

        Collections.sort(edges);
        
        for(int i = 1; i <= n; i++) {
            uf[i] = i;
        }

        for(int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            union(x, y);
        }
        double ans = 0;
        for(int i = 0; i < edges.size(); i++) {
            double dist = edges.get(i).dist;
            int x = edges.get(i).x;
            int y = edges.get(i).y;

            if(find(x) != find(y)) {
                ans += dist;
                union(x, y);
            }
        }

        System.out.printf("%.2f", ans);
    }
}
