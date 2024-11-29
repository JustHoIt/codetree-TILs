import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100000;
    public static int n;
    public static int[] preOrder = new int[MAX_N + 1];
    public static int[] inOrder = new int[MAX_N + 1];
    public static int[] postOrder = new int[MAX_N + 1];
    public static int cnt = 1;

    public static void dfs(int l, int r, int l2, int r2) {
        if(l > r) {
            return;
        }
    
        if(l == r) {
            preOrder[cnt++] = postOrder[l];
            return;
        }

        int rootNum = 0;
        for(int i = l2; i <= r2; i++) {
            if(postOrder[r] == inOrder[i]) {
                rootNum = i;
            }
        }
    
        int lefSz = rootNum - l2;
        int rigSz = r2 - rootNum;
        preOrder[cnt++] = postOrder[r];
        dfs(l, l + lefSz - 1, l2, rootNum - 1);
        dfs(l + lefSz, r - 1, rootNum + 1, r2);
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            inOrder[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            postOrder[i] = sc.nextInt();
        }

        dfs(1, n, 1, n);

        for(int i = 1; i <= n; i++) {
            System.out.print(preOrder[i] + " ");
        }
    }
}