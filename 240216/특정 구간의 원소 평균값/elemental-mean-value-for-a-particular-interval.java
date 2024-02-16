import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;
    public static int[] arr = new int[MAX_N];

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {  
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                boolean ex = false;
                double avg = (double) sum / (j - i + 1);
                for (int k = i; k <= j; k++) {
                    if (arr[k] == avg) {
                        ex = true;
                        break;
                    }
                }
                if (ex) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}