import java.util.Scanner;

public class Main {
    public int solution(int s) {
        int result = 0;
        String a = String.valueOf(s);
        char[] c = a.toCharArray();
        if (s == 1 || s == 11 || s == 111 || s == 1111) {
            c[a.length() -1] = '0';
            a = String.valueOf(c);
        } else {
            for (int i = 0; i < a.length(); i++) {
                if (c[i] == '0') {
                    c[i] = '1';
                    break;
                }
            }
            a = String.valueOf(c);
        }
        result = Integer.parseInt(a, 2);

        return result;

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        System.out.println(T.solution(s));


    }
}