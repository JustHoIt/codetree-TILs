import java.util.Scanner;

public class Main {
    static int MAX = 2000000000;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();

        long start = 1;
        long end = MAX;
        long num = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            if (mid * (mid + 1) / 2 <= s) {
                start = mid + 1;
                num = Math.max(num, mid);
            } else {
                end = mid - 1;
            }
        }
        System.out.println(num);
    }
}