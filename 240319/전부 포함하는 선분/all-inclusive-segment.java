import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] line = new int[n][3];
        int[] result = new int[101];
        int maxV = 0;
        int maxN = 0;
        for (int i = 0; i < n; i++) {
            line[i][0] = sc.nextInt();
            line[i][1] = sc.nextInt();
            line[i][2] = line[i][1] - line[i][0]; //거리
        }
        for (int i = 0; i < n; i++) {
            if (maxV < line[i][2]) {
                maxV = line[i][2];
                maxN = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != maxN) {
                for (int j = line[i][0]; j <= line[i][1]; j++) {
                    result[j] = 1;
                }
            }
        }
        int distance = 0;
        for (int i = 1; i < result.length; i++) {
            if (result[i] == 1 && result[i - 1] != 0) {
                distance++;
            }
        }
        System.out.println(distance);
    }
}