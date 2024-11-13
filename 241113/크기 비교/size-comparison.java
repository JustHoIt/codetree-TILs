import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;
    public static int n, m;
    public static int[][] graph = new int[MAX_N + 1][MAX_N + 1];

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        while(m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if((graph[i][k] > 0) && (graph[k][j] > 0)) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            for(int j = 1; j <= n; j++) {
                if(i == j) {
                    continue;
                }
                if((graph[i][j] > 0) || (graph[j][i] > 0)) {
                    continue;             
                }
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}