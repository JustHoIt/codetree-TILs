import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] ttt = new String[3];

        for (int i = 0; i < 3; i++) {
            ttt[i] = sc.next();
        }


        HashSet<HashSet<Character>> cnt = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            HashSet<Character> check = new HashSet<>();
            for (int j = 0; j < 3; j++) {
                check.add(ttt[i].charAt(j));
            }
            if (check.size() == 2) {
                cnt.add(check);
            }
        }

        for (int j = 0; j < 3; j++) {
            HashSet<Character> check = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                check.add(ttt[i].charAt(j));
            }
            if (check.size() == 2) {
                cnt.add(check);
            }
        }

        HashSet<Character> check = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            check.add(ttt[i].charAt(i));
        }
        if (check.size() == 2) {
            cnt.add(check);
        }

        check = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            check.add(ttt[i].charAt(3 - 1 - i));
        }
        if (check.size() == 2) {
            cnt.add(check);
        }

        System.out.println(cnt.size());
    }
}