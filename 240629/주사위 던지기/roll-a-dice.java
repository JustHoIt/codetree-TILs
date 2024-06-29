import java.util.Scanner;

class Pair { 
    int x, y;
    public Pair(int x, int y) { 
        this.x = x; 
        this.y = y; 
    } 
}

public class Main {
    public static final Pair OUT_OF_GRID = new Pair(-1, -1);
    public static final int DIR_NUM = 4;
    public static final int ASCII_NUM = 128;
    public static final int MAX_N = 100;
    public static int n, m;
    public static int x, y;
    public static int[][] grid = new int[MAX_N][MAX_N];
    
    public static int u = 1, f = 2, r = 3;
    
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    
    public static Pair NextPos(int x, int y, int moveDir) {
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0};
        int nx = x + dx[moveDir], ny = y + dy[moveDir];
        if(inRange(nx, ny)){
            return new Pair(nx, ny);
            }
        else{
            return OUT_OF_GRID;
            }
    }
    
    public static void simulate(int moveDir) {
        // 여기에 코드를 작성해주세요.
        Pair nextPos = NextPos(x, y, moveDir);
        if(nextPos.x == OUT_OF_GRID.x && nextPos.y == OUT_OF_GRID.y){
            return;
        }
        x = nextPos.x;
        y = nextPos.y;
        if(moveDir == 0) { 
            int next_u = 7 - r;
            int next_f = f;
            int next_r = u;
            u = next_u;
            f = next_f;
            r = next_r;
        } else if(moveDir == 1) { 
            int next_u = r;
            int next_f = f;
            int next_r = 7 - u;
            u = next_u;
            f = next_f;
            r = next_r;
        } else if(moveDir == 2) { 
            int next_u = f;
            int next_f = 7 - u;
            int next_r = r;
            u = next_u;
            f = next_f;
            r = next_r;
        } else { 
            int next_u = 7 - f;
            int next_f = u;
            int next_r = r;
            u = next_u;
            f = next_f;
            r = next_r;
        }
        int down = 7 - u;
        grid[x][y] = down;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        x--; y--;
        
        int[] dirMapper = new int[ASCII_NUM];
        dirMapper['R'] = 0;
        dirMapper['L'] = 1;
        dirMapper['U'] = 2;
        dirMapper['D'] = 3;
        
        grid[x][y] = 6;
        for(int i = 0; i < m; i++) {
            char charDir = sc.next().charAt(0);
            simulate(dirMapper[charDir]);
        }
        
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ans += grid[i][j];
                }
            }
        
        System.out.print(ans);
    }
}