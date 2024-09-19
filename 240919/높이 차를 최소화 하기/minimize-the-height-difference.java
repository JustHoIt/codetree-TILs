import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Pair { 
    int x, y;
    public Pair(int x, int y) { 
        this.x = x; 
        this.y = y; 
    } 
}

public class Main {
    public static final int MAX_H = 500;
    public static final int MAX_N = 100;
    public static final int[] dy = new int[]{-1, 0, 1, 0};
    public static final int[] dx = new int[]{0, -1, 0, 1};
    public static int n, m;
    public static int[][] board = new int[MAX_N][MAX_N];
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    
    public static void bfs(int x, int y, int lo, int hi) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int currX = curr.x, currY = curr.y;
            for(int dir = 0; dir < 4; dir++) {
                int nextX = currX + dx[dir];
                int nextY = currY + dy[dir];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m &&
                        board[nextX][nextY] >= lo && board[nextX][nextY] <= hi && !visited[nextX][nextY]) {
                    q.add(new Pair(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
    
    public static void clearVisited() {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) { 
                visited[i][j] = false;
            }
        }
    }
    
    public static boolean reachable(int d) {
        for(int lo = 1; lo <= MAX_H; lo++) {
            clearVisited();
    
            int hi = lo + d;
            if(board[0][0] >= lo && board[0][0] <= hi){
                bfs(0, 0, lo, hi);
            }
            if(visited[n - 1][m - 1]) {
                return true;
            }
        }
    
        return false;
    }

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = sc.nextInt();
            }
        }

        int lo = 0;          
        int hi = MAX_H;       
        int ans = MAX_H;                 

        while(lo <= hi) {                
            int mid = (lo + hi) / 2;      
            if(reachable(mid)) {    
                hi = mid - 1;              
                ans = Math.min(ans, mid);  
            }
            else {
                lo = mid + 1; 
            }     
        }

        System.out.print(ans);
    }
}