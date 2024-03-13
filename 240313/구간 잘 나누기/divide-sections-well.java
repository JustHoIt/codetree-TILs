import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        int left = 0;
        int right = 10000;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(numbers, m, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }

    public static boolean check(int[] numbers, int m, int mid) {
        int count = 1;
        int sum = 0; 
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if (sum > mid) {
                count++;
                sum = numbers[i];
            }
        }
        return count <= m;
    }
}