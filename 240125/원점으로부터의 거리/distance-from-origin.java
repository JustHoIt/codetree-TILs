import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Point[] points = new Point[n];

        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(i+1, x, y);
        }
        Arrays.sort(points);

        for(int i = 0; i < n; i++){
            System.out.println(points[i].idx);
        }
    }
}

class Point implements Comparable<Point>{
    int idx;
    int x;
    int y;
    public Point(int idx, int x, int y){
        this.idx = idx;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o){
        int d1 =  Math.abs(this.x + this.y);
        int d2 =  Math.abs(o.x + o.y);
        if(d1 != d2){
            return d1 - d2;
        }
        return  this.idx - o.idx;
    }
}