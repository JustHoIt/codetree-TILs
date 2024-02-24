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
            int p = s.length() - 1;
            boolean palindromeYn = true;
            
            if (s.length() / 2 == 0) { // i 가 짝수

                for (int j = 0; j < s.length() / 2; j++) {
                    if (c[j] != c[p]) {
                        palindromeYn = false;
                        break;
                    } else {
                        p--;
                    }
                }
            } else { // i가 홀수
                for (int j = 0; j <= s.length() / 2; j++) {
                    if (c[j] != c[p]) {
                        palindromeYn = false;
                        break;
                    }else{
                        p--;
                    }
                }
            }
            if (palindromeYn) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}