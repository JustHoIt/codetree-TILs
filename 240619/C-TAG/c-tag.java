import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static final int MAX_N = 500;
    public static int n, m;
    public static int ans;
    public static String[] A = new String[MAX_N];
    public static String[] B = new String[MAX_N];
    public static HashSet<String> s = new HashSet<>();
    
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++){
            A[i] = sc.next();
        }
        
        for(int i = 0; i < n; i++){
            B[i] = sc.next();
        }
        for (int i = 0; i < m; i++){
            for (int j = i + 1; j < m; j++){
                for (int k = j + 1; k < m; k++){
                    if (solution(i, j, k)){
                        ans++;
                    }
                }
            }
        }
        System.out.print(ans);
    }

    public static boolean solution(int x, int y, int z) {
        s = new HashSet<>();

        for(int i = 0; i < n; i++) {
            s.add(A[i].substring(x, x + 1) + A[i].substring(y, y + 1) + A[i].substring(z, z + 1));
        }
        for(int i = 0; i < n; i++) {
            if(s.contains(B[i].substring(x, x + 1) + B[i].substring(y, y + 1) + B[i].substring(z, z + 1))){
                return false;
            }
        }
        return true;
    }
}