import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100000;
    public static int[] arr = new int[MAX_N + 1];
    public static int n, m;

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int ans = 0;
        
        int sumVal = 0;
        int j = 0;
        for(int i = 1; i <= n; i++) {
            while(j + 1 <= n && sumVal < m) {
                sumVal += arr[j + 1];
                j++;
            }
            
            if(sumVal == m) {
                ans++;
            }
            sumVal -= arr[i];
        }

        System.out.print(ans);
    }
}