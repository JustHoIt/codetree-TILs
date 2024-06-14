import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int coinCount = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (k >= coins[i]) {
                coinCount += k / coins[i]; 
                k %= coins[i]; 
            }
        }

        // 결과 출력
        System.out.println(coinCount);
    }
}