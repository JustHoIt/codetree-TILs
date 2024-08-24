import java.util.Scanner;

public class Main {   
    public static final int MAX_NUM = 100000;
    
    public static int[] A = new int[MAX_NUM + 1];
    public static int[] B = new int[MAX_NUM + 1];
    public static int n, m;
    public static boolean isSubsequence() {
        int i = 1;
        for(int j = 1; j <= m; j++) {
            while(i <= n && A[i] != B[j]) {
                i++;
            }
            
            if(i == n + 1) {
                return false;
            } else {
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            A[i] = sc.nextInt();}
        for(int i = 1; i <= m; i++) {
            B[i] = sc.nextInt();
        }
        if(isSubsequence()){
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}