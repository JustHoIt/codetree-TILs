import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int cnt = N * N * N;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (Math.abs(i - a) > 2 && Math.abs(j - b) > 2 && Math.abs(k - c) > 2) {
                        cnt--;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}