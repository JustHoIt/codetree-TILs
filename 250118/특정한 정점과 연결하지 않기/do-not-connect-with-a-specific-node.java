import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static final int MAX_N = 100000;
    public static int n, m;
    public static int a, b, k;
    public static int[] uf = new int[MAX_N + 1];
    public static int[] sz = new int[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static ArrayList<Integer> groupList = new ArrayList<>();
    
    public static int find(int x) {
        // x가 루트 노드라면 x값을 반환합니다.
        if(uf[x] == x) {
            return x;
        }

        return uf[x] = find(uf[x]);
    }
    
    public static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);

        if(X != Y) {
            uf[X] = Y;
            sz[Y] += sz[X];
        }
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            uf[i] = i;
            sz[i] = 1;
        }

        for(int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            union(x, y);
        }

        a = sc.nextInt();
        b = sc.nextInt();
        k = sc.nextInt();

        int A = find(a);
        int B = find(b);

        for(int i = 1; i <= n; i++) {
            int I = find(i);

            if(I == A || I == B) {
                continue;
            }

            if(visited[I]) {
                continue;
            }

            visited[I] = true;
            groupList.add(sz[I]);
        }
        int szA = sz[A];
        Collections.sort(groupList, Collections.reverseOrder());

        for(int i = 0; i < Math.min(k, groupList.size()); i++) {
            szA += groupList.get(i);
        }

        System.out.print(szA);
    }
}
