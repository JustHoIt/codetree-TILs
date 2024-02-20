import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] x = new int[n];
        int [] y = new int[n];

        for(int i = 0; i < n; i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int minDistance = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++){
            int distance = 0;
            int minX = 0;
            int minY = 0;
            for(int j = i + 1; j < n; j++){
                minX = Math.abs(x[i] - x[j]);
                minY = Math.abs(y[i] - y[j]);
                distance = (minX * minX) + (minY *  minY);
                minDistance = Math.min(minDistance, distance);
            }
        }
        System.out.println(minDistance);
    }
}