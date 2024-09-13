import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_N = 100000;
    public static int n, m, c;
    public static int[] t = new int[MAX_N];
    
    public static boolean isPossible(int wait) {
        int bus = 1;
        int firstArrival = t[0];
        int firstIndex = 0;
        for(int i = 1; i < n; i++) {
            if(t[i] - firstArrival > wait || i + 1 - firstIndex > c) {
                bus += 1;
                firstArrival = t[i];
                firstIndex = i;
            }
        }
        return (bus <= m);
    }
     
    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();
        for(int i = 0; i < n; i++){
            t[i] = sc.nextInt();
        }
        
        Arrays.sort(t, 0, n);

        int lo = 0;                        
        int hi = (int)1e9;                
        int ans = (int)1e9;               

        while(lo <= hi) {                 
            int mid = (lo + hi) / 2;      
            if(isPossible(mid)) {         
                hi = mid - 1;              
                ans = Math.min(ans, mid);  
            } else {
                lo = mid + 1;
            }      
        }

        System.out.print(ans);
    }
}