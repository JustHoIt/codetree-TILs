import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100000;
    public static int n;
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

        for(int i = 1; i <= n; i++) {
            uf[i] = i;
        }

        for(int i = 1; i <= n - 2; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }

        for(int i = 2; i <= n; i++) {
            int I = find(i);
            if(I != find(1)) {
                System.out.print(1 + " " + i);
                break;
            }
        }
    }
}