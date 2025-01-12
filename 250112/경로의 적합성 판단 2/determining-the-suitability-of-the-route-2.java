import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100000;
    public static int n, m, k;
    public static int[] uf = new int[MAX_N + 1];
    public static int[] path = new int[MAX_N + 1];

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
        k = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            uf[i] = i;
        }

        while(m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            union(a, b);
        }

        boolean isPos = true;

        for(int i = 1; i <= k; i++) {
            path[i] = sc.nextInt();
        }

        for(int i = 1; i <= k - 1; i++) {
            if(find(path[i]) != find(path[i + 1])) {
                isPos = false;
            }
        }
        
        if(isPos) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}