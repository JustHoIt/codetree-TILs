import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        char[][] grid = new char[10][10];
        Point L = null, B = null;

        for (int i = 0; i < 10; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < 10; j++) {
                grid[i][j] = s.charAt(j);
                if (grid[i][j] == 'L') {
                    L = new Point(i, j);
                }
                if (grid[i][j] == 'B') {
                    B = new Point(i, j);
                }
            }
        }
        System.out.println(bfs(grid, L, B));

    }

    static int bfs(char[][] grid, Point start, Point end) {
        boolean[][] visited = new boolean[10][10];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y] = true;
        int distance = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                Point current = queue.poll();

                if (current.x == end.x && current.y == end.y) {
                    return distance - 1;
                }

                for (int[] dir : directions) {
                    int nx = current.x + dir[0];
                    int ny = current.y + dir[1];

                    if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10 && !visited[nx][ny] && grid[nx][ny] != 'R') {
                        queue.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1; // 도달할 수 없는 경우
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}