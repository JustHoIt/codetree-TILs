import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

class Tuple implements Comparable<Tuple> {
    int cost, x, y;

    public Tuple(int cost, int x, int y) {
        this.cost = cost;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Tuple t) {
        return this.cost - t.cost;
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final int DIR_NUM = 4;
    public static final int MAX_K = 100;
    public static final int MAX_N = 50;
    public static int n;
    public static int N;
    public static int[][] board = new int[MAX_N + 1][MAX_N + 1];
    public static int[][] renum = new int[MAX_N + 1][MAX_N + 1];
    public static boolean[][] visited = new boolean[MAX_N + 1][MAX_N + 1];
    public static int[][] step = new int[MAX_N + 1][MAX_N + 1];
    public static ArrayList<Tuple> edges = new ArrayList<>();
    public static int[] uf = new int[MAX_K + 1];
    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }
    
    public static boolean canGo(int x, int y) {
        return inRange(x, y) && !visited[x][y] && board[x][y] != -1;
    }
    
    public static int find(int x) {
        if(uf[x] == x) {
            return x;
        }
        return uf[x] = find(uf[x]);
    }
    
    public static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);
        uf[X] = Y;
    }
    
    public static void bfs(int sx, int sy) {
        Queue<Pair> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                visited[i][j] = false;
                step[i][j] = -1;
            }
        }

        visited[sx][sy] = true;
        step[sx][sy] = 0;
        q.add(new Pair(sx, sy));
    
        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();
    
            int[] dx = new int[]{-1, 0, 1, 0};
            int[] dy = new int[]{0, -1, 0, 1};
    
            for(int dir = 0; dir < DIR_NUM; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(!canGo(nx, ny)) {
                    continue;
                }
                visited[nx][ny] = true;
                step[nx][ny] = step[x][y] + 1;
                q.add(new Pair(nx, ny));
    
                if(board[nx][ny] == 1 || board[nx][ny] == 2) {
                    edges.add(new Tuple(step[nx][ny], renum[sx][sy], renum[nx][ny]));
                }
            }
        }
    }
    
    public static int mst() {
        Collections.sort(edges);
    
        for(int i = 1; i <= N; i++) {
            uf[i] = i;
        }
        
        int totalCost = 0;

        for(int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).cost;
            int x = edges.get(i).x;
            int y = edges.get(i).y;
    
            if(find(x) != find(y)) {
    
                totalCost += cost;
                union(x, y);
            }
        }

        boolean isAllConnected = true;

        for(int i = 2; i <= N; i++) {
            int x = find(1);
            int y = find(i);
            if(x != y) {
                isAllConnected = false;
            }
        }
    
        if(isAllConnected){
            return totalCost;
        } else {
            return -1;  
        }
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(board[i][j] == 1 || board[i][j] == 2) {
                    renum[i][j] = ++N;
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(board[i][j] == 1 || board[i][j] == 2) {
                    bfs(i, j);
                }
            }
        }

        System.out.print(mst());
    }
}
