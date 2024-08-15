import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static final int MAX_N = 200000;
    public static int n, k;
    public static int[] arr = new int[MAX_N];
    public static int[] R = new int[MAX_N];

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> latestIndex = new HashMap<>(); 
        for(int i = n - 1; i >= 0; i--) {
            if(!latestIndex.containsKey(arr[i])){
                R[i] = -1;
            } else {
                R[i] = latestIndex.get(arr[i]);
            }
            latestIndex.put(arr[i], i);
        }
        
        int ans = -1;
        for(int i = 0; i < n; i++) {
            if(R[i] != -1 && R[i] - i <= k)
                ans = Math.max(ans, arr[i]);
        }

        System.out.print(ans);
    }
}