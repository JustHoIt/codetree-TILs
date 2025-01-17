import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Tuple implements Comparable<Tuple> {
    int x, y, d;

    public Tuple(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    public int compareTo(Tuple t) {
        return t.d - this.d; 
    }
}

public class Main {
    public static final int MAX_N = 100000;
    public static int n, m;
    public static int a, b;
    public static int[] uf = new int[MAX_N + 1];
    public static ArrayList<Tuple> edges = new ArrayList<>();
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
        a = sc.nextInt();
        b = sc.nextInt();

        for(int i = 1; i <= n; i++){
            uf[i] = i;
        }

        for(int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();

            edges.add(new Tuple(x, y, d));
        }

        Collections.sort(edges);

        for(int i = 0; i < m; i++) {
            int x = edges.get(i).x;
            int y = edges.get(i).y;
            int d = edges.get(i).d;

            union(x, y);
            int A = find(a);
            int B = find(b);

            if(A == B) {
                System.out.print(d);
                break;
            }
        }
    }
}
