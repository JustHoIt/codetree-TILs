import java.util.Scanner;

class Pair { 
    int x, y;
    public Pair(int x, int y) { 
        this.x = x; 
        this.y = y; 
    } 
}

public class Main {
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 20;

    public static int t, n, m;

    public static int[][] a = new int[MAX_N + 1][MAX_N + 1];
    public static int[][] count = new int[MAX_N + 1][MAX_N + 1];
    public static int[][] nextCount = new int[MAX_N + 1][MAX_N + 1];

    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }

    public static Pair getMaxNeighborPos(int currX, int currY) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        int maxNum = 0;
        Pair maxPos = new Pair(-1, -1);
        
        for(int i = 0; i < DIR_NUM; i++) {
            int nextX = currX + dx[i];
            int nextY = currY + dy[i];
            
            if(inRange(nextX, nextY) && a[nextX][nextY] > maxNum) {
                maxNum = a[nextX][nextY];
                maxPos = new Pair(nextX, nextY);
            }
        }
        
        return maxPos;
    }

    public static void move(int x, int y) {
        Pair nextPos = getMaxNeighborPos(x, y);
        int nextX = nextPos.x, nextY = nextPos.y;
        nextCount[nextX][nextY] += 1;
    }

    public static void moveAll() {
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                nextCount[i][j] = 0;
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                if(count[i][j] == 1)
                    move(i, j);
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                count[i][j] = nextCount[i][j];
    }

    public static void removeDuplicateMarbles() {
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                if(count[i][j] >= 2)
                    count[i][j] = 0;
    }

    public static void simulate() {
        moveAll();
        removeDuplicateMarbles();
    }

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();

        for(int i = 1; i <= n; i++)
		    for(int j = 1; j <= n; j++)
                a[i][j] = sc.nextInt();

        for(int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            count[x][y] = 1;
        }

        while(t-- > 0) {
            simulate();
        }

        int ans = 0;
        
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                ans += count[i][j];
        
        System.out.print(ans);
	}
}