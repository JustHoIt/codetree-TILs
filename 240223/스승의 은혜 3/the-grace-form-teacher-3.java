import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        int[] P = new int[N];
        int[] S = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
            S[i] = sc.nextInt();
        }

        int answer = 0;
        for (int i = 0; i < (1 << N); i++) {
            int totalCost = 0;
            int totalCount = 0;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    totalCost += (P[j] / 2) + S[j];
                    totalCount++;
                }
            }

            if (totalCost <= B) {
                answer = Math.max(answer, totalCount);
            }
        }

        System.out.println(answer);
    }
}