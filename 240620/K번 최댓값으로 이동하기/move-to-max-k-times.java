import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Pair { 
    int x, y;
    public Pair(int x, int y) { 
        this.x = x; 
        this.y = y; 
    } 
}

public class Main {
    // 여기에 코드를 작성해주세요.
    public static final Pair NOT_EXISTS = new Pair(-1, -1);
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 100;
    public static int n, k;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static Pair currCell;
    public static Queue<Pair> bfsQ = new LinkedList<>();
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    
    public static boolean canGo(int x, int y, int targetNum) {
        return inRange(x, y) && !visited[x][y] && 
               grid[x][y] < targetNum;
    }
    
    public static void initializeVisited(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                visited[i][j] = false;
            }
        }
    }
    
    public static void BFS() {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
    
        
        int cX = currCell.x;
        int cY = currCell.y;
        visited[cX][cY] = true;
        bfsQ.add(currCell);
        
        int targetNum = grid[cX][cY];
        
        // BFS 탐색을 수행합니다.
        while(!bfsQ.isEmpty()) {
            Pair currPos = bfsQ.poll();
            int currX = currPos.x;
            int currY = currPos.y;
    
            for(int i = 0; i < DIR_NUM; i++) {
                int newX = currX + dx[i];
                int newY = currY + dy[i];
    
                if(canGo(newX, newY, targetNum)) {
                    bfsQ.add(new Pair(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }
    
    public static boolean needUpdate(Pair bestPos, Pair newPos) {
        if(bestPos.x == NOT_EXISTS.x && bestPos.y == NOT_EXISTS.y){
            return true;
        }
        
        int bestX = bestPos.x;
        int bestY = bestPos.y;
        
        int newX = newPos.x;
        int newY = newPos.y;
        if(grid[newX][newY] != grid[bestX][bestY]){
            return grid[newX][newY] > grid[bestX][bestY];
        }
        if(-newX != -bestX){
            return -newX > -bestX;
        }
        return -newY > -bestY;
    }
    public static boolean move() {
        initializeVisited();
        BFS();
        Pair bestPos = NOT_EXISTS;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] || 
                    i == currCell.x && j == currCell.y)
                    continue;
                
                Pair newPos = new Pair(i, j);
                if(needUpdate(bestPos, newPos))
                    bestPos = newPos;
            }
        }
        if(bestPos.x == NOT_EXISTS.x && bestPos.y == NOT_EXISTS.y){
            return false;
        } else {
            currCell = bestPos;
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int r = sc.nextInt();
        int c = sc.nextInt();
        currCell = new Pair(r - 1, c - 1);
        
        while(k-- > 0) {
            boolean isMoved = move();
            if(!isMoved)
                break;
        }
        
        int finalX = currCell.x;
        int finalY = currCell.y;

        System.out.print((finalX + 1) + " " + (finalY + 1));
    }
}