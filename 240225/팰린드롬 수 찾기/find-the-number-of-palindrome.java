import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int cnt = 0;

        for (int i = x; i <= y; i++) {
            String s = String.valueOf(i);
            int[] c = new int[s.length()];
            for (int j = 0; j < s.length(); j++) {
                c[j] = s.charAt(j) - '0';
            }

            // 짝수자리의 수일 경우
            if (s.length() / 2 == 0) {
                boolean palindromeYn = false;
                for (int j = 0; j < s.length(); j++) {
                    int p = s.length() - 1;
                    if (c[j] == c[p]) {
                        palindromeYn = true;
                        p--;
                    } else {
                        break;
                    }
                }
                if (palindromeYn) {
                    cnt++;
                }
            }else{
                boolean palindromeYn = false;
                for (int j = 0; j < s.length() -1; j++) {
                    int p = s.length() - 1;
                    if (c[j] == c[p]) {
                        palindromeYn = true;
                        p--;
                    } else {
                        break;
                    }
                }
                if (palindromeYn) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}