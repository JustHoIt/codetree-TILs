import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Pair implements Comparable<Pair> { 
    int first, second;
    public Pair(int first, int second) { 
        this.first = first; 
        this.second = second; 
    }
    @Override
    public int compareTo(Pair b) {
        if(first != b.first) return first - b.first;
        return second - b.second;
    }
}

public class Main {
    public static int n, k;
    public static int ans;
    
    public static ArrayList<Pair> segments = new ArrayList<>();
    public static ArrayList<Pair> points = new ArrayList<>();

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        
        int curX = 0;
        for(int i = 0; i < n; i++) {
            int dist = sc.nextInt();
            char cDir = sc.next().charAt(0);
            if(cDir == 'L') {
                segments.add(new Pair(curX - dist, curX));
                curX -= dist;
            } else {
                segments.add(new Pair(curX, curX + dist));
                curX += dist;
            }
        }

        for(int i = 0; i < n; i++) {
            int x1 = segments.get(i).first;
            int x2 = segments.get(i).second;
            points.add(new Pair(x1, +1));
            points.add(new Pair(x2, -1)); 
        }

        Collections.sort(points);

        int sumVal = 0;

        for(int i = 0; i < 2 * n; i++) {
            int x = points.get(i).first;
            int v = points.get(i).second;

            if(sumVal >= k) {
                int prevX = points.get(i - 1).first;
                ans += x - prevX;
            }
            sumVal += v;
        }
        
        System.out.print(ans);
    }
}