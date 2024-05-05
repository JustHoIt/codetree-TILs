import java.util.Scanner;

public class Main {
    static int n;
    static int[][] grid;
    static int[][] dp;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        dp = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                max = Math.max(max, findMax(i, j));
            }
        }

        System.out.println(max);
    }

    static int findMax(int x, int y){
        if(dp[x][y] != -1){
            return dp[x][y];
        }

        dp[x][y] = 1;
        for(int dir = 0; dir < 4; dir++){
            int nX = x + dx[dir];
            int nY = y + dy[dir];

            if(nX >= 0 && nX < n && nY >= 0 && nY < n && grid[nX][nY] > grid[x][y]){
                dp[x][y] = Math.max(dp[x][y], findMax(nX, nY) + 1);
            }
        }

        return dp[x][y];
    }
}