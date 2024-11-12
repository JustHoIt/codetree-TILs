import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100;
    public static int n, m;
    public static int v1, v2, e;
    public static int[][] dist = new int[MAX_N + 1][MAX_N + 1];

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v1 = sc.nextInt();
        v2 = sc.nextInt();
        e = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++){
                dist[i][j] = (int)1e8;
            }

            dist[i][i] = 0;
        }

        while(m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            dist[x][y] = dist[y][x] = z;
        }
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

    
        int ans = (int)1e8;
        for(int k = 1; k <= n; k++){
            ans = Math.min(ans, dist[v1][k] + dist[v2][k] + dist[k][e]);
        }

        if(ans == (int)1e8){
            ans = -1;
        }
        
        System.out.print(ans);
    }
}