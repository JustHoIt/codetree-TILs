import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final int MAX_N = 100000;
    public static int n, r, q;
    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[] size = new int[MAX_N + 1];
    
    public static void dfs(int x) {
        size[x] = 1;
    
        for(int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i);
    
            if(visited[y]) { 
                continue;
            }
    
            visited[y] = true;
            dfs(y);

            size[x] += size[y];
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        q = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for(int i = 1; i <= n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            edges[x].add(y);
            edges[y].add(x);
        }

        visited[r] = true;
        dfs(r);

        while(q-- > 0) {
            int x = sc.nextInt();
            System.out.println(size[x]);
        }
    }
}