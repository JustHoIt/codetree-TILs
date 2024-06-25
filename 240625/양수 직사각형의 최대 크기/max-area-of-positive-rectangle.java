import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int [][] square, arr;
    static int n, m;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n  = sc.nextInt();
        m = sc.nextInt();

        square = new int[n][m];


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                square[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution());
    }

     public static int solution() {
        if (square == null || n == 0 || m == 0) {
            return -1;
        }
        int maxArea = 0;
        int[] heights = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (square[i][j] > 0) {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, squareCalc(heights));
        }

        return maxArea > 0 ? maxArea : -1;
    }

    public static int squareCalc(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int[] h = new int[heights.length + 1];
        System.arraycopy(heights, 0, h, 0, heights.length);

        for (int i = 0; i < h.length; i++) {
            while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                int height = h[stack.pop()];
                int width = stack.isEmpty() ? i : i - 1 - stack.peek();
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}