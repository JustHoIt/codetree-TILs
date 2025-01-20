import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100000;
    public static int n, m;
    public static int[] uf = new int[MAX_N + 1];
    public static int[] against = new int[MAX_N + 1];
    public static boolean isCon = false;
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
    
    public static void beta(int x, int y) {
        int X = find(x);
        int Y = find(y);
    
        if(X == Y) {
            isCon = true;
            return;
        }
        
        if(against[X] != 0) {
            union(against[X], Y);
        }
        
        if(against[Y] != 0) {
            union(against[Y], X);
        }
    
        int X2 = find(X);
        int Y2 = find(Y);
    
        against[X2] = Y2;
        against[Y2] = X2;
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            uf[i] = i;
        }

        for(int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            beta(x, y);
        }

        if(isCon) {
            System.out.print(0);
        } else {
            System.out.print(1);
        }
    }
}
