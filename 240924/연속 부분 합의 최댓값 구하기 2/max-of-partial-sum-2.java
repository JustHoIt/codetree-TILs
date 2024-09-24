import java.util.Scanner;

public class Main {    
    public static int INT_MIN = Integer.MIN_VALUE;
    public static final int MAX_N = 100000;
    public static int n;
    public static int[] a = new int[MAX_N + 1];

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            a[i] = sc.nextInt();
        }

        int ans = INT_MIN;
        int sum = 0;

        for(int i = 1; i <= n; i++) {
            if(sum < 0){
                sum = a[i];
            }else{
                sum += a[i];
            }
            ans = Math.max(ans, sum);
        }
        
        System.out.print(ans);
    }
}