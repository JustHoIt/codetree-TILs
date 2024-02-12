import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int OFFSET = 1000000;
    static String[] checked = new String[OFFSET * 2 + 1];
    static int[] x1 = new int[1000];
    static int[] x2 = new int[1000];
    static String[] s1 = new String[1000];
    static int n;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Arrays.fill(checked, "");
        int b = 0, w = 0; // black = b, white = w. gray = g
        int current = OFFSET;  //현재 위치

        for (int i = 0; i < n; i++) {
            int dis = sc.nextInt() - 1;
            s1[i] = sc.next();
            if (s1[i].equals("L")) {
                x1[i] = current - dis;
                x2[i] = current;
                current -= dis;
            } else {
                x1[i] = current;
                x2[i] = current + dis;
                current += dis;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = x1[i]; j <= x2[i]; j++) {
                if (s1[i].equals("L")) {
                    checked[j] = "w";
                } else if (s1[i].equals("R")) {
                    checked[j] = "b";
                }
            }
        }
        for (int i = 0; i < OFFSET * 2 + 1; i++) {
            if (!checked[i].isEmpty()) {
                if (checked[i].equals("b")) {
                    b++;
                } else if (checked[i].equals("w")) {
                    w++;
                }
            }
        }
        System.out.println(w + " " + b);
    }
}