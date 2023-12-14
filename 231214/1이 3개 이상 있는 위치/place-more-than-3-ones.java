import java.util.Scanner;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n = 0;

    public int solution(int[][] arr){
        int answer = 0;

        for(int i = 0; i < n; i++){
            int x = i;
            for(int j = 0; j < n; j++){
                int y = j;
                int count  = 0;
                for(int dir = 0; dir < 4; dir++){
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny]== 1){
                        count++;
                    }  
                }
                if(count >= 3){
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(arr));
    }
}