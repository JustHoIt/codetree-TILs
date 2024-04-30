import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
        static int MAX_INT = Integer.MAX_VALUE;
        static int n, m;
        static int[][] maze;
        static boolean[][] visited;
        static int[] dx = {-1, 1, 0, 0};
        static int[] dy = {0, 0, -1, 1};

        public static void main(String[] args) {
            // 여기에 코드를 작성해주세요.
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            m = sc.nextInt();
            maze = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    maze[i][j] = sc.nextInt();
                }
            }

            int answer = bfs(0, 0);
            System.out.println(answer);
        }

        static int bfs(int x, int y) {
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(x, y, 1));
            visited[x][y] = true;

            while (!q.isEmpty()) {
                Node current = q.poll();

                if (current.x == n - 1 && current.y == m - 1) {
                    return current.distance - 1;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny, current.distance + 1));
                    }
                }
            }
            return -1;
        }

        static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}