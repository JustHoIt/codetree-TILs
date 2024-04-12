import java.util.Scanner;

public class Main {
    public static final int NONE = -1;
    public static final int ASCII_NUM = 128;
    public static final int MAX_N = 4;
    public static int n = 4;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int[][] nextGrid = new int[MAX_N][MAX_N];

    public static void rotate() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nextGrid[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nextGrid[i][j] = grid[n - j - 1][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = nextGrid[i][j];
            }
        }
    }

    public static void drop() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nextGrid[i][j] = 0;
            }
        }
        
        for (int j = 0; j < n; j++) {
            int keepNum = NONE, nextRow = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (grid[i][j] == 0) continue;
                if (keepNum == NONE)
                    keepNum = grid[i][j];
                else if (keepNum == grid[i][j]) {
                    nextGrid[nextRow--][j] = keepNum * 2;
                    keepNum = NONE;
                }
                else {
                    nextGrid[nextRow--][j] = keepNum;
                    keepNum = grid[i][j];
                }
            }
            if (keepNum != NONE) {
                nextGrid[nextRow--][j] = keepNum;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = nextGrid[i][j];
            }
        }
    }
    public static void tilt(int moveDir) {
        for (int i = 0; i < moveDir; i++) {
            rotate();
        }
        drop();
        for (int i = 0; i < 4 - moveDir; i++) {
            rotate();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        char dirChar = sc.next().charAt(0);
        int[] dirMapper = new int[ASCII_NUM];
        dirMapper['D'] = 0;
        dirMapper['R'] = 1;
        dirMapper['U'] = 2;
        dirMapper['L'] = 3;

        // 기울입니다.
        tilt(dirMapper[dirChar]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}