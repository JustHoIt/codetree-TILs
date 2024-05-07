import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int l1 = s1.length();
        int l2 = s2.length();

        int [][] dp = new int[l1 + 1][l2 + 1];
        int max = 0;
        for(int i = 1; i <= l1; i++){
            for(int j = 1;  j <= l2; j++){
                if(s1.charAt(i - 1) == s2.charAt(j -1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println(max);
    }
}