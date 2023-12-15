import java.util.Scanner;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int[] move;
    static int[] dir;
    static int cnt = 0;
    static int answer = 0;


    static int x = 0, y = 0;

    public static int dirNum(String dir) {
        if (dir.equals("N")) {
            return 0;
        } else if (dir.equals("E")) {
            return 1;
        } else if (dir.equals("S")) {
            return 2;
        } else {
            return 3;
        }
    }


    public static int solution() {
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < move[i] ; j++) {
                int dirN = dir[i];
                x = x + dx[dirN];
                y = y + dy[dirN];
                cnt++;

                if(x == 0 && y == 0){
                    answer = cnt;
                    return answer;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dir = new int[n];
        move = new int[n];

        for (int i = 0; i < n; i++) {
            String dirw = sc.next();
            dir[i] = dirNum(dirw);
            move[i] = sc.nextInt();
        }

        System.out.println(T.solution());
    }
}