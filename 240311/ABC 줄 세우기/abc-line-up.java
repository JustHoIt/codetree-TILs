import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().charAt(0) - 'A';
        }

        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean isChange = false;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    isChange = true;
                }
            }
            if (isChange) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}