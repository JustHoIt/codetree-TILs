import java.util.Scanner;

public class Main {
    public static final int MAX_N = 1200000;
    public static int n, q;
    public static boolean[] colored = new boolean[MAX_N + 1];
    public static int lastColoredNode(int dest) {
        int ret = 0;
    
        while(dest > 0) {
            if(colored[dest]) {
                ret = dest;
            }
    
            dest /= 2;
        }
    
        return ret;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt();

        while(q-- > 0) {
            int dest = sc.nextInt();
            int ans = lastColoredNode(dest);
            System.out.println(ans);
            if(ans == 0) {
                colored[dest] = true;
            }
        }
    }
}