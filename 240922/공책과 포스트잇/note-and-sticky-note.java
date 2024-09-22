import java.util.Scanner;
import java.util.Arrays;

public class Main {    
    public static final int MAX_N = 100000;
    public static int n, k, l;
    public static int[] arr = new int[MAX_N];
    
    public static boolean isPossible(int h) {
        long cnt = 0;
        for(int i = n - h; i < n; i++) {
            if(arr[i] < h){
                cnt += h - arr[i];
            }
        }
    
        return cnt <= (long) k * l && arr[n - h] + k >= h;
    }

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        l = sc.nextInt();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr, 0, n);
        
        int left = 1;                          
        int right = n;                         
        int ans = 0;                         
        
        while (left <= right) {              
            int mid = (left + right) / 2;     
            if(isPossible(mid)) {             
                left = mid + 1;               
                ans = Math.max(ans, mid);   
            } else {                      
                right = mid - 1;  
            }            
        }

        System.out.print(ans);
    }
}