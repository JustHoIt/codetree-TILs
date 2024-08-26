import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_N = 100000;
    public static int[] arr = new int[MAX_N + 1];
    public static int n, k;

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, 1, n + 1);
        int ans = 0;

        int j = n;
        for(int i = 1; i <= n; i++) {
            while(j != 1 && arr[i] + arr[j] > k){
                j--;
            }

            if(j <= i){
                break;
            }
            ans += j - i;
        }

        System.out.print(ans);
    }
}