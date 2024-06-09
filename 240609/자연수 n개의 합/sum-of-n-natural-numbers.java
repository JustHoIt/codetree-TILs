import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();

        long start = 1, end = s;
        while (start < end) {
            long mid = (start + end + 1) / 2;
            if (sum(mid) <= s) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }

    private static long sum(long n) {
        return n * (n + 1) / 2;
    }
}