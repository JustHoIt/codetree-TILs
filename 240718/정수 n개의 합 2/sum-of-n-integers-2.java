import java.util.Scanner;

public class Main {    
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int MAX_N = 100000;
    public static int n, k;
    public static int[] arr = new int[MAX_N + 1];
    public static int[] prefixSum = new int[MAX_N + 1];
    public static int ans = INT_MIN;
    
    public static int getSum(int s, int e) {
        return prefixSum[e] - prefixSum[s - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }

        prefixSum[0] = 0;
        for(int i = 1; i<= n; i++){
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        for(int i = 1; i <= n - k + 1; i++){
            ans = Math.max(ans, getSum(i, i + k - 1));
        }

        System.out.print(ans);
    }
}