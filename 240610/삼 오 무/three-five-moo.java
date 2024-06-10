import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long start = 1;
        long end = 2 * n;
        long result = -1;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (countNonMoo(mid) >= n) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(result);
    }

        private static long countNonMoo(long num) {
        long count = num; 
        count -= num / 3;  
        count -= num / 5;  
        count += num / 15; 
        return count;
    }
}