import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;

    public static int n, m, k;
    public static int[][] grid = new int[MAX_N][MAX_N];
    
    public static boolean allBlank(int row, int colS, int colE) {
        for(int col = colS; col <= colE ; col++) {
            if (grid[row][col] > 0){

                return false;
            }
        }

        return true;
    }
    
    public static int getTargetRow() {
        for(int row = 0; row < n - 1; row++) {
            if (!allBlank(row + 1, k, k + m - 1)) {
                return row;
            }
        }

        return n - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        k--;

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int targetRow = getTargetRow();
        for(int col = k; col < k + m; col++) {
            grid[targetRow][col] = 1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}