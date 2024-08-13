import java.util.Scanner;

public class Main {    
    public static final int MAX_N = 100000;
    
    public static int n;
    public static String str;
    public static int[] R = new int[MAX_N];

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        n = str.length();
        R[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--) {
            if(str.charAt(i) == ')' && str.charAt(i + 1) == ')'){
                R[i] = R[i + 1] + 1;
            } else {
                R[i] = R[i + 1];
            }
        }

        long ans = 0;
        for(int i = 0; i < n - 2; i++) {
            if(str.charAt(i) == '(' && str.charAt(i + 1) == '('){
                ans += R[i + 2];
            }
        }
        
        System.out.print(ans);
    }
}