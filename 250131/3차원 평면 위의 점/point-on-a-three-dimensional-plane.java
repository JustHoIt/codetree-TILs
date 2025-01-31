import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

class Point {
    int x, y, z, idx;

    Point(int x, int y, int z, int idx) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.idx = idx;
    }
};

public class Main {
    public static final int MAX_N = 100000;
    public static int n;
    public static ArrayList<Tuple> edges = new ArrayList<>();
    public static int[] uf = new int[MAX_N + 1];
    public static ArrayList<Point> points = new ArrayList<>();

    public static boolean cmpx(Point a, Point b) {
        return a.x < b.x;
    }

    public static class CmpX implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            return p1.x - p2.x;
        }
    }
    
    public static class CmpY implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            return p1.y - p2.y;
        }
    }
    
    public static class CmpZ implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            return p1.z - p2.z;
        }
    }
    
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
    
    public static void push(Point p1, Point p2) {
        int cost = Math.min(Math.min(Math.abs(p1.x - p2.x), Math.abs(p1.y - p2.y)), Math.abs(p1.z - p2.z));
        edges.add(new Tuple(cost, p1.idx, p2.idx));
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            points.add(new Point(x, y, z, i));
        }

        Collections.sort(points, new CmpX());

        for(int i = 0; i < n - 1; i++) {
            push(points.get(i), points.get(i + 1));
        }

        Collections.sort(points, new CmpY());

        for(int i = 0; i < n - 1; i++) {
            push(points.get(i), points.get(i + 1));
        }

        Collections.sort(points, new CmpZ());

        for(int i = 0; i < n - 1; i++) {
            push(points.get(i), points.get(i + 1));
        }

        Collections.sort(edges);

        for(int i = 1; i <= n; i++) {
            uf[i] = i;
        }
        
        int ans = 0;
        for(int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).cost;
            int x = edges.get(i).x;
            int y = edges.get(i).y;

            if(find(x) != find(y)) {
                ans += cost;
                union(x, y);
            }
        }

        System.out.print(ans);
    }
}
