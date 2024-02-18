import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int H = sc.nextInt(); //목표 높이
        int T = sc.nextInt(); //목표 횟수
        int[] ground = new int[N];
        
        // 땅 높이 입력 받기
        for (int i = 0; i < N; i++) {
            ground[i] = sc.nextInt();
        }
        
        int highMin = Integer.MAX_VALUE;
        
        for (int i = 0; i <= N - T; i++) {
            int num = 0;
            num = Math.abs(H - ground[i]);
            for (int j = i + 1; j <= i + T - 1; j++) {
                num += Math.abs(H - ground[j]);
            }
            highMin = Math.min(num, highMin);
        }
        System.out.println(highMin);
    }
}