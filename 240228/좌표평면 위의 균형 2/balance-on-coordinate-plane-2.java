import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] coordinate = new int[101][101];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            coordinate[x][y] = 1;
        }
        int answer = Integer.MAX_VALUE;

        for (int i = 2; i <= 98; i += 2) {
            for (int j = 2; j < 98; j += 2) {
                int[] cnt = new int[4];
                for (int k = 1; k < 100; k++) {
                    for (int l = 1; l < 100; l++) {
                        if (coordinate[k][l] == 1) {
                            if (k < i && l < j) { // 1
                                cnt[0]++;
                            } else if (k > i && l < j) {
                                cnt[1]++;
                            } else if (k < i && l > j) {
                                cnt[2]++;
                            } else if (k > i && l > j) {
                                cnt[3]++;
                            }
                        }
                    }
                }
                int max = 0;
                for (int k = 0; k < cnt.length; k++) {
                    max = Math.max(max, cnt[k]);
                }
                answer = Math.min(answer, max);
            }
        }
        System.out.println(answer);
    }
}