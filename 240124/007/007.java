import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String secretCode = sc.next();
        String meetingPoint = sc.next();
        int time = sc.nextInt();


        Place p = new Place(secretCode, meetingPoint, time);

        System.out.println("secret code : " + p.secretCode);
        System.out.println("meeting point : " + p.meetingPoint);
        System.out.println("time : " + p.time);
    }
}

class Place {
    String secretCode;
    String meetingPoint;
    int time;
    public Place(String secretCode, String meetingPoint, int time){
        this.secretCode = secretCode;
        this.meetingPoint = meetingPoint;
        this.time = time;
    }
}