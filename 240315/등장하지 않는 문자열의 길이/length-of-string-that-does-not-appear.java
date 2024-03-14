import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        for (int i = 1; i <= n; i++) {
            boolean isSame = false;

            for (int j = 0; j <= n - i; j++) {
                String sub = s.substring(j, j + i);
                int count = 0;

                for (int k = 0; k <= n - i; k++) {
                    if (s.startsWith(sub, k)) {
                        count++;
                    }
                }

                if (count >= 2) {
                    isSame = true;
                    break;
                }
            }

            if (!isSame) {
                System.out.println(i);
                break;
            }
        }
    }
}