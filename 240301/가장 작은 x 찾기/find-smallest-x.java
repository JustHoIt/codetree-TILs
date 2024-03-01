import java.util.Scanner;

public class Main {
    public static final int MAX_N = 10;
    public static final int MAX_NUM = 10000;

    public static int n;
    public static int[] a = new int[MAX_N];
    public static int[] b = new int[MAX_N];
    
    public static boolean satisfy(int x) {
        for(int i = 0; i < n; i++) {
            x *= 2;
            if(x < a[i] || x > b[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        for(int x = 1; x <= MAX_NUM; x++)
            if(satisfy(x)) {
                System.out.print(x);
                break;
            }
    }
}