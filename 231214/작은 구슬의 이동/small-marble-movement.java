import java.util.Scanner;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n = 0, t = 0;
    static int x = 0, y = 0;

    public static int getDir(String a) {
        char d = a.charAt(0);
        if (d == 'U') {
            return 0;
        } else if (d == 'D') {
            return 1;
        } else if (d == 'R') {
            return 2;
        } else {
            return 3;
        }
    }

    public int cngDir(int d) {
        if (d == 0) {
            return 1;
        } else if (d == 1) {
            return 0;
        } else if (d == 2) {
            return 3;
        } else {
            return 2;
        }
    }


    public void solution(int r, int c, int d) {
        for (int i = 0; i < t; i++) {
            if (x > 0 && x < n - 1 && y > 0 && y < n - 1) {
                x = x + dx[d];
                y = y + dy[d];
            } else {
                d = cngDir(d);
            }
        }


    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        String a = sc.next();
        x = r;
        y = c;

        int d = getDir(a);
        T.solution(r, c, d);

        System.out.println((x + 1) + " " + (y + 1));
    }
}