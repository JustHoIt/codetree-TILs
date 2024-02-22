import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] bombs = new int[N];

        for (int i = 0; i < N; i++) {
            bombs[i] = sc.nextInt();
        }

        int maxNum = -1;

        for (int i = 0; i <= N; i++) {
            for (int j = i + 1; j <= i + K; j++) {
                if(j == N){
                    break;
                }
                if (j < N && bombs[i] == bombs[j]) {
                    maxNum = Math.max(maxNum, bombs[i]);
                }
            }
        }
        System.out.println(maxNum);
    }
}