import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_H = 100;
    public static final int MAX_N = 1000;
    
    public static int n;
    public static int k = 17;
    public static int[] arr = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int ans = INT_MAX;
        for(int i = 0; i <= MAX_H; i++) {
            int cost = 0;
            for(int j = 0; j < n; j++) {
                if(arr[j] < i){
                    cost += (arr[j] - i) * (arr[j] - i);
                }
                if(arr[j] > i + k){
                    cost += (arr[j] - i - k) * (arr[j] - i - k);
                }
            }

            ans = Math.min(ans, cost);
        }
        
        System.out.print(ans);
    }
}