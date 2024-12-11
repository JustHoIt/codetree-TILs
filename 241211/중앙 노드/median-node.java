import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final int MAX_N = 100000;
    public static int n, r;
    public static int midNode;
    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[] treeSize = new int[MAX_N + 1];
    public static int maxSize, minSize = MAX_N;
    
    public static void findMidNode(int x) {
        int child = edges[x].size() - 1;
    
        if(x == r) {
            child++;
        }
    
        if(child >= 2 && midNode == 0) {
            midNode = x;
        }
    
        if(child == 0 && midNode == 0) {
            midNode = x;
        }
    
        for(int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i);
            
            if(visited[y]) {
                continue;
            }
            
            visited[y] = true;
            findMidNode(y);
        }
    }

    public static void dfs(int x) {
        treeSize[x] = 1;
    
        for(int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i);
    
            if(visited[y]) {
                continue;
            }
    
            visited[y] = true;
            dfs(y);
    
            treeSize[x] += treeSize[y];
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();

        for(int i = 1; i <= n; i++){
            edges[i] = new ArrayList<>();
        }
        
        for(int i = 1; i <= n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            edges[x].add(y);
            edges[y].add(x);
        }

        visited[r] = true;
        findMidNode(r);

        for(int i = 1; i <= n; i++) {
            visited[i] = false;
        }
        visited[midNode] = true;
        dfs(midNode);

        for(int i = 0; i < edges[midNode].size(); i++) {
            int y = edges[midNode].get(i);

            maxSize = Math.max(maxSize, treeSize[y]);
            minSize = Math.min(minSize, treeSize[y]);
        }

        System.out.print(maxSize - minSize);
    }
}