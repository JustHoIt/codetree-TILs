import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] startPoints = new int[n];
        int[] endPoints = new int[n];

        for (int i = 0; i < n; i++) {
            startPoints[i] = sc.nextInt();
            endPoints[i] = sc.nextInt();
        }

        int totalMin = 101, totalMax = 0;
        for (int i = 0; i < n; i++) {
            if (startPoints[i] < totalMin) totalMin = startPoints[i];
            if (endPoints[i] > totalMax) totalMax = endPoints[i];
        }

        int answer = totalMax - totalMin;
        for (int i = 0; i < n; i++) {
            int localMin = 101, localMax = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue; // 현재 선분을 제외
                if (startPoints[j] < localMin) localMin = startPoints[j];
                if (endPoints[j] > localMax) localMax = endPoints[j];
            }
            int localLength = localMax - localMin;
            if (localLength < answer) answer = localLength;
        }

        System.out.println(answer);
    }
}