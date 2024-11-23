import java.util.Scanner;

public class Main {
    public static final int MAX_N = 200000;
    public static int n;
    public static long k;
    public static int[] leftNum = new int[MAX_N + 1];
    public static int[] rightNum = new int[MAX_N + 1];
    public static int ans;
    
    public static void dfs(int x, long ballNum) {
        if(leftNum[x] == -1 && rightNum[x] == -1) {
            ans = x;
            return;
        }
        if(leftNum[x] == -1){
            dfs(rightNum[x], ballNum);
        }else if(rightNum[x] == -1) {
            dfs(leftNum[x], ballNum);
        }else if(ballNum % 2 == 1) {
            dfs(leftNum[x], (ballNum + 1) / 2);
        }else {
            dfs(rightNum[x], ballNum / 2);
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            leftNum[i] = sc.nextInt();
            rightNum[i] = sc.nextInt();
        }

        k = sc.nextLong();
        dfs(1, k);

        System.out.print(ans);
    }
}