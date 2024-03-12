import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static int n;
    public static String seats;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        seats = sc.next();
        int maxDist = 0;
        int maxI = 0, maxJ = 0;
        for(int i = 0; i < n; i++) {
            if(seats.charAt(i) == '1') {
                for(int j = i + 1; j < n; j++)
                    if(seats.charAt(j) == '1') {
                        if(j - i > maxDist) {
                            maxDist = j - i;
                            maxI = i;
                            maxJ = j;
                        }
                        break;
                    }
            }
        }
        int maxDist2 = -1;
        int maxIdx = -1;
        if(seats.charAt(0) == '0') {
            int dist = 0;
            for(int i = 0; i < n; i++) {
                if(seats.charAt(i) == '1'){
                    break;
                }
                dist++;
            }
            if(dist > maxDist2) {
                maxDist2 = dist;
                maxIdx = 0;
            }
        }

        // 맨 뒷 좌석이 비어있을 때, 맨 뒷 좌석에 배정하면
        // 거리가 얼마나 줄어드는지 확인합니다.
        if(seats.charAt(n - 1) == '0') {
            int dist = 0;
            for(int i = n - 1; i >= 0; i--) {
                if(seats.charAt(i) == '1'){
                    break;
                }
                dist++;
            }
            if(dist > maxDist2) {
                maxDist2 = dist;
                maxIdx = n - 1;
            }
        }

        if(maxDist2 >= maxDist / 2){
            seats = seats.substring(0, maxIdx) + '1' + seats.substring(maxIdx + 1);
        }else{
            seats = seats.substring(0, (maxI + maxJ) / 2) + '1' + seats.substring((maxI + maxJ) / 2 + 1);
        }
        int ans = INT_MAX;
        for(int i = 0; i < n; i++) {
            if(seats.charAt(i) == '1') {
                for(int j = i + 1; j < n; j++)
                    if(seats.charAt(j) == '1') {
                        ans = Math.min(ans, j - i);
                        break;
                    }
            }
        }
        System.out.print(ans);
    }
}