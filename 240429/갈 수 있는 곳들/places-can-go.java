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
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 100;
    public static int n, k;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static Queue<Pair> bfsQ = new LinkedList<>();
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    
    public static boolean canGo(int x, int y) {
        return inRange(x, y) && grid[x][y] == 0 && !visited[x][y];
    }
    
    public static void BFS() {
        while(!bfsQ.isEmpty()) {
            Pair currPos = bfsQ.poll();
            int x = currPos.x, y = currPos.y;
    
            int[] dx = new int[]{1, -1, 0, 0};
            int[] dy = new int[]{0, 0, 1, -1};

            for(int dir = 0; dir < DIR_NUM; dir++) {
                int nx = x + dx[dir], ny = y + dy[dir];

                if(canGo(nx, ny)){
                    bfsQ.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        while(k-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            bfsQ.add(new Pair(x - 1, y - 1));
            visited[x - 1][y - 1] = true;
        }
        BFS();

        int ans = 0;
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(visited[i][j])
                    ans++;
        
        System.out.print(ans);
    }
}