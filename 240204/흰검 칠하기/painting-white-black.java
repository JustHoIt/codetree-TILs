import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int MAX_VALUE = 2000001;
    static int offset = 1000000;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] checked = new String[MAX_VALUE];
        Arrays.fill(checked, "");
        int[] x1 = new int[1000];
        int[] x2 = new int[1000];
        String[] s1 = new String[1000];
        int[] ckw = new int[MAX_VALUE];
        int[] ckb = new int[MAX_VALUE];

        int b = 0, w = 0, g = 0; // black = b, white = w. gray = g
        int current = 0;  //현재 위치

        for (int i = 0; i < n; i++) {
            int dis = sc.nextInt();
            String x = sc.next();

            if (x.equals("L")) {
                x1[i] = current - dis;
                x2[i] = current;
                s1[i] = "w";
                current -= dis;
            } else {
                x1[i] = current;
                x2[i] = current + dis;
                s1[i] = "b";
                current += dis;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = x1[i] + offset; j < x2[i] + offset; j++) {
                checked[j] = s1[i];
                if (s1[i].equals("w")) {
                    ckw[j]++;
                } else if (s1[i].equals("b")) {
                    ckb[j]++;
                }
            }
        }
        for (int i = 0; i < MAX_VALUE; i++) {
            if (ckb[i] + ckw[i] > 3) {
                checked[i] = "g";
            }
        }
        for (int i = 0; i < MAX_VALUE; i++) {
            if (!checked[i].isEmpty()) {
                if (checked[i].equals("b")) {
                    b++;
                } else if (checked[i].equals("w")) {
                    w++;
                } else if (checked[i].equals("g")) {
                    g++;
                }
            }
        }
        System.out.println(w + " " + b + " " + g);
    }
}