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
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int DIR_NUM = 8;
    public static final int MAX_N = 100;

    public static int n;
    public static int r1, c1, r2, c2;

    public static Queue<Pair> q = new LinkedList<>();
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    public static int[][] step = new int[MAX_N][MAX_N];
    
    public static int ans = INT_MAX;
    
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static boolean canGo(int x, int y) {
        return inRange(x, y) && !visited[x][y];
    }

    public static void push(int nx, int ny, int newStep) {
        q.add(new Pair(nx, ny));
        visited[nx][ny] = true;
        step[nx][ny] = newStep;
    }
    public static void findMin() {
        while(!q.isEmpty()) {
            Pair currPos = q.poll();
            int x = currPos.x, y = currPos.y;
    
            int[] dx = new int[]{-2, -2, -1, -1,  1, 1,  2, 2};
            int[] dy = new int[]{-1,  1, -2,  2, -2, 2, -1, 1};
            for(int dir = 0; dir < DIR_NUM; dir++) {
                int nx = x + dx[dir], ny = y + dy[dir];
                if(canGo(nx, ny)){
                    push(nx, ny, step[x][y] + 1);
                }
            }
        }
        if(visited[r2][c2]){
            ans = step[r2][c2];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();
        
        r1--; 
        c1--; 
        r2--; 
        c2--;
        push(r1, c1, 0);
        findMin();

        if(ans == INT_MAX){ 
            ans = -1; 
        }
         
        System.out.print(ans);
    }
}