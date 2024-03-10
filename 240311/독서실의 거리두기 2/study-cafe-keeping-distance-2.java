import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] seats = new int[n];
        String s = sc.next();
        for (int i = 0; i < n; i++) {
            seats[i] = s.charAt(i) - '0';
        }
        int max =0;

        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                int leftDistance = n;
                int rightDistance = n;

                for (int j = i - 1; j >= 0; j--) {
                    if (seats[j] == 1) {
                        leftDistance = i - j;
                        break;
                    }
                }

                for (int j = i + 1; j < n; j++) {
                    if (seats[j] == 1) {
                        rightDistance = j - i;
                        break;
                    }
                }
                int currentDistance = Math.min(leftDistance, rightDistance);
                max  = Math.max(currentDistance, max);
            }
        }
        System.out.println(max);
    }
}