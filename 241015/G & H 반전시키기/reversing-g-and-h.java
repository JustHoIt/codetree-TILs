import java.util.Scanner;

public class Main {    
    public static final int MAX_N = 1000;
    
    public static int n;
    public static String a;
    public static String b;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = sc.next();
        b = sc.next();
        int ans = 0;
        boolean mismatched = false;
        for(int i = 0; i < n; i++) {
            if(a.charAt(i) != b.charAt(i)) {
                if(!mismatched) {
                    mismatched = true;
                    ans++;
                }
            } else {
                mismatched = false;
            }
        }
        System.out.print(ans);
    }
}