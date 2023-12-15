import java.util.Scanner;

public class Main {
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};
    static int x = 0, y = 0, t = 0;
    static int dir = 0;

    public static int solution(String dirS){
        int answer = 0;
        char[] dirC = dirS.toCharArray();

        for(int i = 0; i < dirC.length; i++){
            if(dirC[i] == 'F'){
                x = x + dx[dir];
                y = y + dy[dir];
                t++;
                if(x == 0 && y == 0){
                    answer = t;
                    return answer;
                }
            }else{
                dir = cngDir(dirC[i]);
                t++;
            }
        }
        return -1;
    }

    public static int cngDir(char c){
        if(c == 'L'){
            dir--;
            if(dir == -1){
                dir = 3;
            }    
        }else{
            dir++;
            if(dir == 4){
                dir = 0;
            }
        }
        return dir;
    }
    


    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String dirS = sc.next();

        System.out.println(T.solution(dirS));
    }
}