import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int cnt = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] cost = new int[n];

        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }

        Arrays.sort(cost);

        int money = b;
        for (int i = 0; i < n; i++) {
            if (money > 0 && money >= cost[i]) {
                money -= cost[i];
                cnt++;
            } else if (cost[i] > money) {
                int a = cost[i] / 2;
                if (a > money) {
                    break;
                } else {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}