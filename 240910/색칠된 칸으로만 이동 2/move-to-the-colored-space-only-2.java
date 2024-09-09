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
    public static final int MAX_N = 100;
    
    public static final int[] dy = new int[]{-1, 0, 1, 0};
    public static final int[] dx = new int[]{0, -1, 0, 1};

    public static int m, n;
    public static int startX, startY;
    public static int[][] board = new int[MAX_N][MAX_N];
    public static int[][] colored = new int[MAX_N][MAX_N];
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    public static void bfs(int d) {
        Queue<Pair> q = new LinkedList<>();
    
        q.add(new Pair(startX, startY));
        visited[startX][startY] = true;
    
        while (!q.isEmpty()) {
            Pair p = q.poll();
    
            for(int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i], nextY = p.y + dy[i];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n){
                    if (!visited[nextX][nextY] && Math.abs(board[p.x][p.y] - board[nextX][nextY]) <= d) {
                        q.add(new Pair(nextX, nextY));
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
    
    public static boolean reachable(int d) {
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    
        bfs(d);
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if((colored[i][j] > 0) && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                colored[i][j] = sc.nextInt();
                if(colored[i][j] > 0) {
                    startX = i;
                    startY = j;
                }
            }
        }
        int lo = 0;                    
        int hi = 1000000000;            
        int ans = 0;                

        while(lo <= hi) {               
            int mid = (lo + hi) / 2;    
            if(reachable(mid)) {      
                hi = mid - 1;           
                ans = mid;     
            } else {
                lo = mid + 1;   
            }      
        }
        System.out.print(ans);
    }
}