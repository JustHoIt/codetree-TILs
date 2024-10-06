import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static final int MAX_N = 50000;
    public static int n;
    public static int[] aCards = new int[MAX_N];
    public static int[] bCards = new int[MAX_N];
    
    public static HashSet<Integer> bSet = new HashSet<>();

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            bCards[i] = sc.nextInt();
            bSet.add(bCards[i]);
        }
        
        int cardIdx = 0;
        for(int i = 1; i <= 2 * n; i++){
            if(!bSet.contains(i)){
                aCards[cardIdx++] = i;
            }
        }
        Arrays.sort(aCards, 0, n);
        Arrays.sort(bCards, 0, n);
        
        int ans = 0;
        int bIdx = 0;
        for(int aIdx = 0; aIdx < n; aIdx++) {
            if(bIdx < n && aCards[aIdx] > bCards[bIdx]) {
                ans++;
                bIdx++;
            }
        }

        System.out.print(ans);
    }
}