import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Point> que = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            que.add(new Point(x, y));
        }

        for(int i = 0; i < m; i++){
            Point clo = que.poll();
            clo.x += 2;
            clo.y += 2;
            clo.dis = Math.abs(clo.x) + Math.abs(clo.y);
            que.add(clo);
        }

        Point ans = que.peek();
        System.out.println(ans.x + " " + ans.y);
    }
}

class Point implements Comparable<Point>{
    int x, y;
    int dis;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
        this.dis = Math.abs(x) + Math.abs(y);
    }

    @Override
    public int compareTo(Point o){
        if(this.dis == o.dis){
            if(this.x == o.x){
                return this.y - o.y;
            }
            return this.x - o.x;
        }
        return this.dis - o.dis;
    }
}