import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100000;
    public static int n, m;
    public static int[] uf = new int[MAX_N + 1];
    public static int find(int x) {
        if(uf[x] == x){
            return x;
        }
        return uf[x] = find(uf[x]);
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            uf[i] = i;
        }

        int ans = m;
        for(int i = 1; i <= m; i++) {
            int x = sc.nextInt();

            int X = find(x);
            if(X == 0) {
                ans = i - 1;
                break;
            }

            int Y = find(X - 1);
            uf[X] = Y;
        }
        System.out.print(ans);
    }
}
