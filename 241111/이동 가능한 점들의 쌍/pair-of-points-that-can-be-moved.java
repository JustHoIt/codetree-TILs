import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 200;
    public static int n, m, p, q;
    public static int[][] dist = new int[MAX_N + 1][MAX_N + 1];

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        p = sc.nextInt();
        q = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                dist[i][j] = (int)1e9;
            }
            dist[i][i] = 0;
        }

        while(m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            dist[x][y] = z;
        }
        
        for(int k = 1; k <= n; k++) { 
            for(int i = 1; i <= n; i++) { 
                for(int j = 1; j <= n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        long ans = 0;
        int cnt = 0;

        for(int i = 1; i <= q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int distance = (int)1e9;
            for(int j = 1; j <= p; j++) {
                distance = Math.min(distance, dist[x][j] + dist[j][y]);
            }

            if(distance >= (int)1e9) {
                continue;
            }
                
            ans += distance;
            cnt++;
        }

        System.out.println(cnt);
        System.out.print(ans);
    }
}