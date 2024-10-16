import java.util.Scanner;

public class Main {    
    public static int n;
    public static String a;
    public static String b;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = sc.next();
        b = sc.next();
        int cnt = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(a.charAt(i) != b.charAt(i) && cnt % 2 == 0){
                cnt++;
            }else if(a.charAt(i) == b.charAt(i) && cnt % 2 == 1){
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}