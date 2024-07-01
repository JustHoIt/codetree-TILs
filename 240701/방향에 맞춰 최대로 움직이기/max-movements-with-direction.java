import java.util.Scanner;

public class Main {
    static final int MAX_N = 4;
    static int[][] numbers = new int[MAX_N][MAX_N]; 
    static int[][] directions = new int[MAX_N][MAX_N];  
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};  
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1}; 

    static int n; 
    static int r, c; 
    static int movingDist;  
    static int ans; 

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        numbers = new int[n][n];
        directions = new int[n][n];
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                numbers[i][j] = sc.nextInt();
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                directions[i][j] = sc.nextInt() - 1;
            }

        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;

        solution(r, c);
        System.out.println(ans);
    }

    static boolean InRange(int x, int y) {  
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static boolean CanGo(int x, int y, int priorNum) { 
        return InRange(x, y) && numbers[x][y] > priorNum;
    }

    static void solution(int x, int y) {
        for (int i = 1; i < n; i++) {
            int nx = x + dx[directions[x][y]] * i;
            int ny = y + dy[directions[x][y]] * i;
            if (CanGo(nx, ny, numbers[x][y])) {
                movingDist++; 
                ans = Math.max(ans, movingDist); 
                solution(nx, ny);  
                movingDist--; 
            }
        }
    }
}