import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int time = 0;
        int speed = 1;
        int distance = 0;

        while (distance < x) {
            time++;
            distance += speed;

            if(x - distance >= (speed + 1) * (speed + 2) / 2){
                speed++;
            }else if(x - distance >= speed * (speed + 1) / 2){
                speed = speed;
            }else{
                speed--;
            }
        }

        System.out.println(time);
    }
}