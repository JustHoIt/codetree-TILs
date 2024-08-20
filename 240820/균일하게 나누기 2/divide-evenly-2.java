import java.util.Scanner;
import java.util.Arrays;

class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x; 
    }
}

public class Main {    
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_Q = 4;
    public static final int MAX_R = 1000;
    public static final int MAX_N = 1000;
    public static int n;
    public static Point[] points = new Point[MAX_N];
    
    public static int ans = INT_MAX;

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }

        Arrays.sort(points, 0, n);
        for(int b = 0; b <= MAX_R; b += 2) {
            int[] cnt = new int[MAX_Q + 1];

            for(int i = 0; i < n; i++) {
                if(points[i].y > b){
                    cnt[1]++;
                } else {
                    cnt[4]++;}
            }
            for(int i = 0; i < n; i++) {
                if(i == 0 || points[i].x != points[i - 1].x) {
                    int maxCnt = 0;
                    for(int j = 1; j <= MAX_Q; j++)
                        maxCnt = Math.max(maxCnt, cnt[j]);
                    
                    ans = Math.min(ans, maxCnt);
                }
                if(points[i].y > b) {
                    cnt[1]--;
                    cnt[2]++;
                } else {
                    cnt[4]--;
                    cnt[3]++;
                }
            }
        }
        System.out.print(ans);
    }
}