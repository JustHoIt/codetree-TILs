import java.util.Scanner;

public class Main {
    public static final int MAX_K = 4;
    public static final int MAX_N = 12;
    public static int n, m, k;
    public static int[] nums = new int[MAX_N];
    public static int[] pieces = new int[MAX_K];
    public static int ans;
    
    public static int calc() {
        int score = 0;
        for(int i = 0; i < k; i++){
            score += (pieces[i] >= m ? 1 : 0);
        }
        
        return score;
    }
    
    public static void findMax(int cnt) {
        ans = Math.max(ans, calc());
        if(cnt == n) {
            return;
        }
        
        for(int i = 0; i < k; i++) {
            if(pieces[i] >= m){
                continue;
            }
            pieces[i] += nums[cnt];
            findMax(cnt + 1);
            pieces[i] -= nums[cnt];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        
        for(int i = 0; i < k; i++){
            pieces[i] = 1;
        }
        
        findMax(0);
        
        System.out.print(ans);
    }
}