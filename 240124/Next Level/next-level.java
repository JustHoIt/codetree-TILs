import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc =new Scanner(System.in);
        String user = sc.next();
        int lv = sc.nextInt();

        User u =new User();
        System.out.println("user " + u.user + " lv " + u.lv);
        u.user = user;
        u.lv = lv;
        System.out.println("user " + u.user + " lv " + u.lv);
    }
}

class User{
    String user;
    int lv;
    public User(){
        this.user = "codetree";
        this.lv = 10;
    }

    public User(String user, int lv){
        this.user = user;
        this.lv = lv;
    }

}