import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List <Game> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String user = sc.next();
            int point = sc.nextInt();
            arr.add(new Game(user, point));
        }

        String s = "";
        int aPoint = 0;
        int bPoint = 0;
        int cPoint = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int p = arr.get(i).point;
            if(p == 0){
                continue;
            }
            if(arr.get(i).user.equals("A")){
                aPoint += p;
            }else if(arr.get(i).user.equals("B")){
                bPoint += p;
            }else{
                cPoint += p;
            }

            if(aPoint > bPoint && aPoint > cPoint){
                if(!s.equals("A")){
                    cnt++;
                }
                s = "A";
            }else if(bPoint > aPoint && bPoint > cPoint){
                if(!s.equals("B")){
                    cnt++;
                }
                s = "B";
            }else if(cPoint > aPoint && cPoint > bPoint){
                if(!s.equals("C")){
                    cnt++;
                }
                s = "C";
            }else{
                if(!s.equals("ABC")) {
                    cnt++;
                }
                s = "ABC";

            }
        }
        System.out.println(cnt);
    }
}

class Game {
    String user;
    int point;

    Game(String user, int point){
        this.user = user;
        this.point = point;
    }
}