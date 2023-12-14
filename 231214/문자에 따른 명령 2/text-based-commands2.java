import java.util.Scanner;

public class Main {
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};
    static String[] dirs = {"N","E","S","W"};
    static int dir = 0;
    static int x = 0, y = 0;

    public void solution(String command){
        char[] commands = command.toCharArray();
        for(int i = 0; i < commands.length; i++){
            if(command.charAt(i) == 'F'){
                if(dir == 0){
                    x = x + dx[0];
                    y = y + dy[0];
                }else if(dir == 1){
                    x = x + dx[1];
                    y = y + dy[1];
                }else if(dir == 2){
                    x = x + dx[2];
                    y = y + dy[2];
                }else{
                    x = x + dx[3];
                    y = y + dy[3];
                }
            }else{
                if(command.charAt(i) == 'L'){
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
            }
        }

    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String command = sc.next();
        T.solution(command);
        System.out.print(x + " " + y);
        // 여기에 코드를 작성해주세요.
    }
}