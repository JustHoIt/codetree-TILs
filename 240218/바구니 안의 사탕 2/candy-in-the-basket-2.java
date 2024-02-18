import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 100;
    
    public static int n, k;
    public static int[] arr = new int[MAX_NUM + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int x = sc.nextInt();
            
            arr[x] += a;
        }
        
        int maxSum = 0;
        for(int i = 0; i <= MAX_NUM; i++) {
            int sum = 0;
            for(int j = i - k; j <= i + k; j++)
                if(j >= 0 && j <= MAX_NUM){
                    sum += arr[j];
                }
            maxSum = Math.max(maxSum, sum);
        }           
        System.out.print(maxSum);
    }
}