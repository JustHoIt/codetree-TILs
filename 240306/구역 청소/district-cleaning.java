import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int[] area = new int[101];
        int cnt = 0;
        int block = 0;

        for (int i = 0; i < 2; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int j = x; j <= y; j++) {
                area[j] = 1;
            }
        }

        for (int i = 0; i < 101; i++) {
            if (area[i] == 1) {
                cnt++;
                if (i == 0 || (i > 0 && area[i - 1] == 0)) {
                    block++;
                }
            }
        }
        if (block == 1) {
            System.out.println(cnt - 1);
        } else {
            System.out.println(cnt - 2);
        }
    }
}