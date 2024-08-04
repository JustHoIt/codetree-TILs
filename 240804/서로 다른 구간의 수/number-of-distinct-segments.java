import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Segment {
    int x1, x2;

    public Segment(int x1, int x2){
        this.x1 = x1;
        this.x2 = x2;
    }
};

class Point implements Comparable<Point> {
    int x, v, index;

    public Point(int x, int v, int index){
        this.x = x;
        this.v = v;
        this.index = index;
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x;
    }
};

public class Main {    
    public static final int MAX_N = 100000;
    public static int n;
    public static Segment[] segments = new Segment[MAX_N];

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            segments[i] = new Segment(x1, x2);
        }   
        ArrayList<Point> points = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            int x1 = segments[i].x1;
            int x2 = segments[i].x2;
            points.add(new Point(x1, +1, i));
            points.add(new Point(x2, -1, i));
        }

        Collections.sort(points);
        HashSet<Integer> segs = new HashSet<>();

        int ans = 0;
        for(int i = 0; i < 2 * n; i++) {
            int x = points.get(i).x;
            int v = points.get(i).v;
            
            int index = points.get(i).index;
            if(v == +1) {
                if(segs.size() == 0){
                    ans++;
                }
                segs.add(index);
            }
            else {
                segs.remove(index);
            }
        }
        
        System.out.println(ans);
    }
}