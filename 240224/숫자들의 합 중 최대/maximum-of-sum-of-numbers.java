import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int maxValue = Integer.MIN_VALUE;
        for (int i = x; i <= y; i++) {
            String s = String.valueOf(i);
            int[] k = new int[s.length()];

            for (int j = 0; j < s.length(); j++) {
                k[j] = s.charAt(j) - '0';
            }
            int sum = 0;
            for (int j = 0; j < k.length; j++) {
                sum += k[j];
            }

            maxValue = Math.max(sum, maxValue);
        }
        System.out.println(maxValue);
    }
}