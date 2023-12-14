import java.util.Scanner;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int x = 0, y = 0;

    public void solution(String dirc, int move){
         if(dirc.equals("N")){
            for(int i = 1; i <= move; i++){
                x = x + dx[0];
                y = y + dy[0];
            }
        }else if(dirc.equals("E")){
            for(int i = 1; i <= move; i++){
                x = x + dx[1];
                y = y + dy[1];
            }
        }else if(dirc.equals("S")){
            for(int i = 1; i <= move; i++){
                x = x + dx[2];
                y = y + dy[2];
            }
        }else{
            for(int i = 1; i <= move; i++){
                x = x + dx[3];
                y = y + dy[3];
            }
        }
    }
    

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            String dirc = sc.next();
            int move = sc.nextInt();
            T.solution(dirc, move);
        }
        System.out.print(x +" "+ y);
    }
}