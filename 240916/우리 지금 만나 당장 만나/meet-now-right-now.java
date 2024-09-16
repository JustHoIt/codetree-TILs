import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100000;
    public static int n;
    public static int[] x = new int[MAX_N];
    public static int[] v = new int[MAX_N];
     
    public static boolean isPossible(double time) {
        double maxX1 = x[0] - v[0] * time;
        double minX2 = x[0] + v[0] * time;
        for(int i = 1; i < n; i++) {
            double x1 = x[i] - v[i] * time;
            double x2 = x[i] + v[i] * time;
            maxX1 = Math.max(maxX1, x1);
            minX2 = Math.min(minX2, x2);
        }
    
        return maxX1 <= minX2;
    }
     
    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) x[i] = sc.nextInt();
        for(int i = 0; i < n; i++) v[i] = sc.nextInt();

        double lo = 0;                    
        double hi = 1e9;              
        double ans = 1e9;      

        for(int i = 1; i <= 100; i++) {    
            double mid = (lo + hi) / 2;   
            if(isPossible(mid)) {       
                hi = mid;                
                ans = Math.min(ans, mid);
            }else{ 
                lo = mid;
            }               
        }
        System.out.printf("%.4f", ans);
    }
}