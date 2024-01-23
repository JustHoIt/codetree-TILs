import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String code = sc.next();
        String color = sc.next();
        int second = sc.nextInt();
        Bomb b = new Bomb(code, color, second);

        System.out.println("code : " + b.code);
        System.out.println("color : " + b.color );
        System.out.println("second : " + b.second);
    }
}

class Bomb{
    String code;
    String color;
    int second;
    public Bomb(String code, String color, int second){
        this.code = code;
        this.color = color;
        this.second = second;
    }
}