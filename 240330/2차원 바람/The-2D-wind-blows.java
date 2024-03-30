import java.util.Scanner;

public class Main {
    public static final int MAX_M = 100;
    public static final int MAX_N = 100;
    public static final int DIR_NUM = 5;
    
    // 전역 변수 선언:
    public static int n, m, q;
    
    public static int[][] a = new int[MAX_N + 1][MAX_M + 1];
    public static int[][] tempArr = new int[MAX_N + 1][MAX_M + 1];
    
    
    // 직사각형의 경계에 있는 숫자들을 시계 방향으로 한 칸씩 회전해줍니다.
    public static void rotate(int startRow, int startCol, int endRow, int endCol) {
        // Step1-1. 직사각형 가장 왼쪽 위 모서리 값을 temp에 저장합니다.
        int temp = a[startRow][startCol];

        for(int row = startRow; row < endRow; row++){
            a[row][startCol] = a[row + 1][startCol];
        }

        for(int col = startCol; col < endCol; col++){
            a[endRow][col] = a[endRow][col + 1];

        }
    
        for(int row = endRow; row > startRow; row--){
            a[row][endCol] = a[row - 1][endCol];
        }

        for(int col = endCol; col > startCol; col--){
            a[startRow][col] = a[startRow][col - 1];

        }
        a[startRow][startCol + 1] = temp;
    }

    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= m;
    }

    public static int average(int x, int y) {
        int[] dx = new int[]{0, 1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 0, 1, -1};
        
        int sum = 0, cnt = 0;
    
        for(int dir = 0; dir < DIR_NUM; dir++){
            int nx = x + dx[dir], ny = y + dy[dir];
            if(inRange(nx, ny)) {
                sum += a[nx][ny]; cnt++;
            }
        }
    
        return sum / cnt;
    }
    public static void setAverage(int startRow, int startCol, int endRow, int endCol) {
        for(int row = startRow; row <= endRow; row++){
            for(int col = startCol; col <= endCol; col++){
                tempArr[row][col] = average(row, col);
            }
        }

        for(int row = startRow; row <= endRow; row++){
            for(int col = startCol; col <= endCol; col++){
                a[row][col] = tempArr[row][col];
            }
        }
    }

    public static void simulate(int startRow, int startCol, int endRow, int endCol) {
        rotate(startRow, startCol, endRow, endCol);
        setAverage(startRow, startCol, endRow, endCol);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        
        for(int row = 1; row <= n; row++){
            for(int col = 1; col <= m; col++){
                a[row][col] = sc.nextInt();
            }
        }
        
        while(q-- > 0) {
            int r1, c1, r2, c2;
            r1 = sc.nextInt();
            c1 = sc.nextInt();
            r2 = sc.nextInt();
            c2 = sc.nextInt();
            simulate(r1, c1, r2, c2);
        }

        for(int row = 1; row <= n; row++) {
            for(int col = 1; col <= m; col++){
            System.out.print(a[row][col] + " ");
            }    
            System.out.println();
        }
    }
}