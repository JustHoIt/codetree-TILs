import java.util.Scanner;

public class Main {
    public static final int MAX_N = 1024;
    public static int k, n;
    public static int[] a = new int[MAX_N + 1];
    public static int[] treeNum = new int[MAX_N + 1];
    public static int cnt = 1;
    
    public static void inOrder(int x) {
        if(x > n){
            return;
        }
    
        inOrder(x * 2);
        treeNum[x] = a[cnt++];
        inOrder(x * 2 + 1);
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = (1 << k) - 1;

        for(int i = 1; i <= n; i++){
            a[i] = sc.nextInt();
        }

        inOrder(1);

        for(int i = 1; i <= k; i++) {
            for(int j = (1 << (i - 1)); j <= (1 << i) - 1; j++) {
                System.out.print(treeNum[j] + " ");
            }
            System.out.println();
        }
    }
}