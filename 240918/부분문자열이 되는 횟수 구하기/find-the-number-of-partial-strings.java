import java.util.Scanner;

public class Main {
    public static final int MAX_N = 200000;
    public static int n, m;
    public static String a, b;
    public static int[] del = new int[MAX_N + 1];
    public static boolean[] skip = new boolean[MAX_N + 1];
    
    public static boolean isPossible(int mid) {
        int bIdx = 0;
        for(int i = 1; i <= mid; i++) {
            skip[del[i] - 1] = true;
        }
        for(int i = 0; i <= n - 1; i++) {
            if(skip[i]) continue;
            if(bIdx < m && a.charAt(i) == b.charAt(bIdx)) bIdx++;
        }
    
        return bIdx == m;
    }

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        a = sc.next();
        b = sc.next();
        n = a.length();
        m = b.length();
        for(int i = 1; i <= n; i++) del[i] = sc.nextInt();
        
        int lo = 0;    
        int hi = n; 
        int ans = -1;     
        
        while(lo <= hi) {                  
            int mid = (lo + hi) / 2;       
            if(isPossible(mid)) {        
                lo = mid + 1;              
                ans = Math.max(ans, mid); 
            } else {
                hi = mid - 1;   
            }  

            for(int i = 1; i <= mid; i++) {
                skip[del[i] - 1] = false;
            }
        }
        
        System.out.print(ans + 1);
    }
}