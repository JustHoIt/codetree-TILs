import java.util.Scanner;

public class Main {    
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100000;
    public static int[] arr = new int[MAX_N + 1];
    public static int n, s;

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = INT_MAX;
        
        int sumVal = 0;
        int j = 0;
        for(int i = 1; i <= n; i++) {
            while(j + 1 <= n && sumVal < s) {
                sumVal += arr[j + 1];
                j++;
            }
            if(sumVal < s) {
                break;
            }
            ans = Math.min(ans, j - i + 1);

            sumVal -= arr[i];
        }

        if(ans == INT_MAX) {
            ans = -1;
        }

        System.out.print(ans);
    }
}