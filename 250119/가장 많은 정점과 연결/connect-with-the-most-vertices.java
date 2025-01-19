import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static final int MAX_M = 100002;
    public static final int MAX_N = 100002;
    
    public static int n, m, k;
    public static int[] minCost = new int[MAX_N+ 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static ArrayList<Integer> costList = new ArrayList<>();
    public static int[] uf = new int[MAX_N + 1];
    
    public static int find(int x) {
        if(uf[x] == x) {
        return uf[x] = find(uf[x]);
        }
    }
    
    public static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);
        uf[X] = Y;
        minCost[Y] = Math.min(minCost[Y], minCost[X]);
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            minCost[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            uf[i] = i;
        }

        for(int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            union(x, y);
        }

        for(int i = 1; i <= n; i++) {
            int I = find(i);

            if(visited[I]) {
                continue;
            }
            
            visited[I] = true;
            costList.add(minCost[I]);
        }

        Collections.sort(costList);

        int ans = 0;
        for(int i = 1; i < costList.size(); i++) {
            ans += costList.get(0) + costList.get(i);
        }

        if(ans <= k) {
            System.out.print(ans);
        } else {
            System.out.print("NO");
        }
    }
}
