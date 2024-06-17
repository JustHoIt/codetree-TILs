import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<Point> points = new TreeSet<>();
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            points.add(new Point(x, y));
        }

        for(int i = 0; i < m; i++){
            int k = sc.nextInt();
            Point queryPoint = new Point(k, Integer.MIN_VALUE);
            Point result = points.ceiling(queryPoint);

            if (result == null) {
                System.out.println("-1 -1");
            } else {
                System.out.println(result);
                points.remove(result);
            }
        }

    }
}

class Point implements Comparable<Point> {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point other) {
        if (this.x != other.x) {
            return Integer.compare(this.x, other.x);
        } else {
            return Integer.compare(this.y, other.y);
        }
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}