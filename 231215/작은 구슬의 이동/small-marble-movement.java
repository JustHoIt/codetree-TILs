import java.util.Scanner;

public class Main {
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int n = 0, t = 0;
    static int x = 0, y = 0;

    public static int getDir(String a) {
        char d = a.charAt(0);
        if (d == 'R') {
            return 0;
        } else if (d == 'D') {
            return 1;
        } else if (d == 'U') {
            return 2;
        } else {
            return 3;
        }
    }

    public void solution(int r, int c, int d) {
        for (int i = 0; i < t; i++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < n  && ny >= 0 && ny < n) {
                x = nx;
                y = ny;
            } else {
                d = 3 - d;
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