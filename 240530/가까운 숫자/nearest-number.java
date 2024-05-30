import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100000;

    public static int n;
    public static int[] arr = new int[MAX_N];
    public static int ans = INT_MAX;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();

        n = sc.nextInt();

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        set.add(0);

        for(int i = 0; i < n; i++){
            if(set.higher(arr[i]) != null){
                ans = Math.min(ans, set.higher(arr[i]) - arr[i]);
            }

            ans = Math.min(ans, arr[i] - set.lower(arr[i]));
            
            set.add(arr[i]);
            System.out.println(ans);
        }
    }
}