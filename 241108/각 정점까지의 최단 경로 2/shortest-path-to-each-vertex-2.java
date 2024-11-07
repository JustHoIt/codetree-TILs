import java.util.Scanner;

public class Main {    
    public static final int MAX_N = 100;
    public static int n, m;
    public static int[][] dist = new int[MAX_N + 1][MAX_N + 1];

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++){
                dist[i][j] = (int)1e9;
            }
            dist[i][i] = 0;
        }

        while(m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            dist[x][y] = Math.min(dist[x][y], z);
        }
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(dist[i][j] == (int)1e9) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(dist[i][j] + " ");}
            }
            System.out.println();
        }
    }
}