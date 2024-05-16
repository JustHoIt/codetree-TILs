import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;

public class Main {
    static final int MAX_NUM = 25;
    static int n;
    static int[][] board = new int[MAX_NUM][MAX_NUM];
    static boolean[][] visited = new boolean[MAX_NUM][MAX_NUM];
    static ArrayList<Integer> answer = new ArrayList<>();

    static int [] dx = {1, 0, -1, 0};
    static int [] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && board[i][j] == 1){
                    answer.add(DFS(i, j));
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for(int i : answer){
            System.out.println(i);
        }
    }

    public static int DFS(int x, int y){
        int ps = 0;
        Stack<Position> st = new Stack<>();
        visited[x][y] = true;
        st.push(new Position(x, y));

        while (!st.isEmpty()) {
            Position current = st.pop();
            ps++;

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny] || board[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                st.push(new Position(nx, ny));
            }
        }
        return ps;
    }
    
    static class Position{
    int x;
    int y;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }   
}