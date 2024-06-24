import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;
    public static final int DIR_NUM = 4;
    public static int n;
    public static int currX, currY, currDir;
    public static char[][] a = new char[MAX_N + 1][MAX_N + 1];
    public static boolean[][][] visited = new boolean[MAX_N + 1][MAX_N + 1][DIR_NUM];
    
    public static int elapsedTime;
    
    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }

    public static boolean wallExist(int x, int y) {
        return inRange(x, y) && a[x][y] == '#';
    }
    
    public static void simulate() {
        if(visited[currX][currY][currDir]) {
            System.out.print(-1);
            System.exit(0);
        }
        visited[currX][currY][currDir] = true;
    
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
    
        int nextX = currX + dx[currDir];
        int nextY = currY + dy[currDir];
        if(wallExist(nextX, nextY)){
            currDir = (currDir - 1 + 4) % 4;
        } else if(!inRange(nextX, nextY)) {
            currX = nextX; currY = nextY;
            elapsedTime++;
        } else {
            int rx = nextX + dx[(currDir + 1) % 4];
            int ry = nextY + dy[(currDir + 1) % 4];
            if(wallExist(rx, ry)) {
                currX = nextX; currY = nextY;
                elapsedTime++;
            }
            else {
                currX = rx; currY = ry;
                currDir = (currDir + 1) % 4;
                elapsedTime += 2;
            }
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        currX = sc.nextInt();
        currY = sc.nextInt();
        currDir = 0;

        for(int i = 1; i <= n; i++) {
            String str = sc.next();
            for(int j = 1; j <= n; j++){
                a[i][j] = str.charAt(j - 1);
            }
        }
        
        do {
            simulate();
        } while(inRange(currX, currY)); 
        System.out.print(elapsedTime);
    }
}