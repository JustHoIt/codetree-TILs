import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static final int MAX_K = 100000;
    public static final int MAX_N = 100000;

    public static int[] a = new int[MAX_K];
    public static int[] b = new int[MAX_K];
    public static int[] arr = new int[MAX_N + 1];
    public static int[] ans = new int[MAX_N + 1];
    public static HashSet<Integer>[] s = new HashSet[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        for(int i = 0; i < k; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++){
            s[i] = new HashSet<Integer>();
        }

        for(int i = 1; i <= n; i++) {
            arr[i] = i;
            s[i].add(i);
            ans[i] = 1;
        }

        for(int cnt = 0; cnt < 3; cnt++) {
            for(int i = 0; i < k; i++) {
                int temp = arr[a[i]];
                arr[a[i]] = arr[b[i]];
                arr[b[i]] = temp;

                if(!s[arr[a[i]]].contains(a[i])) {
                    s[arr[a[i]]].add(a[i]);
                    ans[arr[a[i]]]++;
                }
                
                if(!s[arr[b[i]]].contains(b[i])) {
                    s[arr[b[i]]].add(b[i]);
                    ans[arr[b[i]]]++;
                }
            }
        }

        for(int i = 1; i <= n; i++){
            System.out.println(ans[i]);}
        }
}