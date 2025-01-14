import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100000;
    public static int n, m;
    public static int[] uf = new int[MAX_N + 1];
    public static int[] sz = new int[MAX_N + 1];

    public static int find(int x) {
        if(uf[x] == x) {
            return x;
        }
        return uf[x] = find(uf[x]);
    }

    public static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);
        if(X != Y) {
            uf[X] = Y;
            sz[Y] += sz[X];
        }
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); 
        m = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            uf[i] = i;
            sz[i] = 1;
        }

        while(m-- > 0) {
            char query = sc.next().charAt(0);

            if(query == 'x') {
                int a = sc.nextInt();
                int b = sc.nextInt();

                union(a, b);
            } else {
                int a = sc.nextInt();
                int A = find(a);
                System.out.println(sz[A]);
            }
        }
    }
}