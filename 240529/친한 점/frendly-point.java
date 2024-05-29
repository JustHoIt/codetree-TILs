import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    static class Point implements Comparable<Point>{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        TreeSet<Point> set = new TreeSet<>();
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            set.add(new Point(x, y));
        }

        for(int i = 0; i < m;  i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            Point qPoint = new Point(x, y);
            
            Point fPoint = null;
            for(Point p : set.tailSet(qPoint)){
                if(p.x > x || (p.x == x && p.y >= y)){
                    fPoint = p;
                    break;
                }
            }

            if(fPoint != null){
                System.out.println(fPoint.x + " " + fPoint.y);
            }else{
                System.out.println("-1 -1");
            }
        }




    }
}