import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

class Segment {
    int y, x1, x2;

    public Segment(int y, int x1, int x2) {
        this.y = y;
        this.x1 = x1;
        this.x2 = x2;
    }
}

class Point implements Comparable<Point> {
    int x, v, index, y;

    public Point(int x, int v, int index, int y) {
        this.x = x;
        this.v = v;
        this.index = index;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x; 
    }
}

class Element implements Comparable<Element> {
    int y, index;

    public Element(int y, int index) {
        this.y = y;
        this.index = index;
    }

    @Override
    public int compareTo(Element e) {
        return this.y - e.y; 
    }
}

public class Main {    
    public static final int MAX_N = 50000;
    public static int n;
    public static Segment[] segments = new Segment[MAX_N];
    public static boolean[] visible = new boolean[MAX_N];

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int y = sc.nextInt();
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            segments[i] = new Segment(y, x1, x2);
        }
        ArrayList<Point> points = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            int y = segments[i].y;
            int x1 = segments[i].x1;
            int x2 = segments[i].x2;
            points.add(new Point(x1, +1, i, y));
            points.add(new Point(x2, -1, i, y));
        }
        Collections.sort(points);
        TreeSet<Element> segs = new TreeSet<>();
        for(int i = 0; i < 2 * n; i++) {
            int v = points.get(i).v;
            int index = points.get(i).index;
            int y = points.get(i).y;
            if(v == +1) {
                segs.add(new Element(y, index));
            } else {
                segs.remove(new Element(y, index));
            }

            if(segs.isEmpty()){
                continue;
            }
            int targetIndex = segs.first().index;
            visible[targetIndex] = true;
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(visible[i]){
                ans++;
            }
        }
        
        System.out.print(ans);
    }
}