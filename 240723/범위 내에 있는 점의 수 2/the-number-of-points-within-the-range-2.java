import java.util.Scanner;

public class Main {
    public static final int MAX_A = 1000000;
    public static final int MAX_N = 100000;
    public static int n, q;
    public static int[] arr = new int[MAX_N + 1];
    public static int[] prefixSum = new int[MAX_A + 1];

    public static int getSum(int s, int e) {
        if(s == 0) {
            return prefixSum[e];
        }
        return prefixSum[e] - prefixSum[s - 1];
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            prefixSum[arr[i]]++;
        }

        for(int i = 1; i <= MAX_A; i++){
            prefixSum[i] += prefixSum[i - 1];
        }
        
        for(int i = 1; i <= q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(getSum(l, r));
        }
    }
}