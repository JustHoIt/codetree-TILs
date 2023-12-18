import java.util.Scanner;

public class Main {
    public int solution(String s) {
        int result = 0;
        if (s.length() < 4) {
            while (true) {
                s = 0 + s;
                if (s.length() == 3) {
                    s = 1 + s;
                    break;
                }
            }
        } else {
            char[] c = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                if (c[i] == '0') {
                    c[i] = '1';
                    break;
                }
            }
            s = String.valueOf(c);
        }
        result = Integer.parseInt(s, 2);

        return result;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(T.solution(s));
    }
}