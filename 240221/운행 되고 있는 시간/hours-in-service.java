import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] developers = new int[n][2];

        for (int i = 0; i < n; i++) {
            developers[i][0] = sc.nextInt();
            developers[i][1] = sc.nextInt();
        }

        int[] schedule = new int[1001];
        int maxWorkTime = 0;

        for (int i = 0; i < n; i++) {
            Arrays.fill(schedule, 0); 
            int workTime = 0;

            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = developers[j][0]; k < developers[j][1]; k++) {
                    schedule[k] = 1;
                }
            }
            for (int j = 0; j < schedule.length; j++) {
                if (schedule[j] == 1) {
                    workTime++;
                }
            }
            maxWorkTime = Math.max(maxWorkTime, workTime);
        }
        System.out.println(maxWorkTime);
    }
}