import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 100;
    public static final int DIR_NUM = 2;
    public static int n, m;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];
    public static int[][] visited = new int[MAX_NUM][MAX_NUM];
    
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y))
            return false;
        if(visited[x][y] == 1 || grid[x][y] == 0)
            return false;
        return true;
    }

    public static void DFS(int x, int y) {
        int[] dx = new int[]{1, 0};
        int[] dy = new int[]{0, 1};
        for(int i = 0; i < DIR_NUM; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(canGo(newX, newY)) {
                visited[newX][newY] = 1;
                DFS(newX, newY);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        visited[0][0] = 1;
        DFS(0, 0);

        System.out.println(visited[n - 1][m - 1]);
    }
}