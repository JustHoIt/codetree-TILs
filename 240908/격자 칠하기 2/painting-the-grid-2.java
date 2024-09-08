import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;
    public static final int[] dx = new int[]{1, -1, 0, 0};
    public static final int[] dy = new int[]{0, 0, 1, -1};
    public static int n;
    public static int[][] board = new int[MAX_N][MAX_N];
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    public static int dfs(int x, int y, int d) {
        if(visited[x][y])
            return 0;
        
        visited[x][y] = true;
        int count = 1;
        for(int dir = 0; dir < 4; dir++) {
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n &&
                    Math.abs(board[nextX][nextY] - board[x][y]) <= d) {
                count += dfs(nextX, nextY, d);
            }
        }
        return count;
    }
    
    public static boolean isPossible(int d) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    if(dfs(i, j, d) * 2 >= n*n) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int lo = 0;                  
        int hi = 1000000;             
        int ans = 0;               

        while(lo <= hi) {                
            int mid = (lo + hi) / 2;      
            if(isPossible(mid)) {        
                hi = mid - 1;            
                ans = mid;               
            } else {
                lo = mid + 1; 
            }         
        }

        System.out.print(ans);
    }
}