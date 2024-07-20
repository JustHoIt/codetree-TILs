import java.util.Scanner;

public class Main {
    public static final int MAX_N = 1000;
    public static int n, k;
    public static int[] arr = new int[MAX_N + 1];
    public static int[] prefixSum = new int[MAX_N + 1];
    public static int ans;
    public static int getSum(int s, int e) {
        return prefixSum[e] - prefixSum[s - 1];
    }

    public static void main(String[] args) {
        //여기에 코드를 입력해주세요.
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
        for(int i = 1; i <= n; i++){
            for(int j = i; j <= n; j++){
                if(getSum(i, j) == k){
                    ans++;
                }
            }
        }

        System.out.print(ans);
    }
}