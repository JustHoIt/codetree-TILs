import java.util.Scanner;

public class Main {
    public static final int MAX_M = 100;

    public static int n, m;
    public static int[] a = new int[MAX_M];
    public static int[] b = new int[MAX_M];

    public static int countNum(int first, int second) {
        int cnt = 0;
        for(int i = 0; i < m; i++) {
            if(first == a[i] && second == b[i])
                cnt++;
            else if(second == a[i] && first == b[i])
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        int ans = 0;
        for(int i = 1; i <= n; i++)
            for(int j = i + 1; j <= n; j++)
                ans = Math.max(ans, countNum(i, j));

        System.out.println(ans);
    }
}