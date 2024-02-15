import java.util.Scanner;

public class Main {
    static int MAX_VALUE = 10000000;
    static char[] line = new char[MAX_VALUE + 1];

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int maxV = 0;
        int maxNum = 0;
        for (int i = 0; i < N; i++) {
            int l = sc.nextInt();
            maxV = Math.max(maxV, l);
            line[l] = sc.next().charAt(0);
        }
        for (int i = 1; i <= maxV - K + 1; i++) {
            int num = 0;
            for (int j = i; j <= i + K; j++) {
                if (line[j] == 'G') {
                    num += 1;
                } else if (line[j] == 'H') {
                    num += 2;
                }
            }
            maxNum = Math.max(maxNum, num);
        }
        System.out.println(maxNum);
    }
}