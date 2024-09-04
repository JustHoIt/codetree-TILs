import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_NUM = 100000;
    public static int[] fires = new int[MAX_NUM + 1];
    public static int[] stations = new int[MAX_NUM + 1];
    public static int n, m;
    
    public static int dist(int i, int j) {
        return Math.abs(fires[i] - stations[j]);
    }
    
    public static int putOutFire() {
        int maxDist = 0;
    
        int j = 1;
        for(int i = 1; i <= n; i++) {
            while(j + 1 <= m && dist(i, j) > dist(i, j + 1)) {
                j++;
            }
            maxDist = Math.max(maxDist, dist(i, j));
        }
    
        return maxDist;
    }

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            fires[i] = sc.nextInt();
        }
        for(int i = 1; i <= m; i++) {
            stations[i] = sc.nextInt();
        }

        Arrays.sort(fires, 1, n + 1);
        Arrays.sort(stations, 1, m + 1);
        System.out.print(putOutFire());
    }
}