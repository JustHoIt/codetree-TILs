import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_N = 50000;
    public static int n, k;
    public static int[] pos = new int[MAX_N];
     
    public static boolean isPossible(int mid) {
        //여기에 코드를 작성해주세요.
        int cnt = 1; 
        int idx = 0;           
        for(int i = 0; i < n; i++) {
            if(pos[i] - pos[idx] <= 2 * mid){ 
                continue;
            } else {
                cnt++;
                idx = i;
            }
        }
    
        return cnt <= k;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i < n; i++) {
            pos[i] = sc.nextInt();
        }

        Arrays.sort(pos, 0, n);

        int lo = 0;  
        int hi = (int)1e9;                
        int ans = (int)1e9;            

        while(lo <= hi){                  
            int mid = (lo + hi) / 2;
            if(isPossible(mid)){         
                hi = mid - 1;               
                ans = Math.min(ans, mid);   
            }else{
                lo = mid + 1;  
            }         
        }
        System.out.print(ans);
    }
}