import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int [] digits = new int[20];
        int cnt = 0;
        int n = sc.nextInt();
        int b = sc.nextInt();
        while(true){
            if(b == 4){
                if(n < 4) {
                digits[cnt++] = n;
                break;
            }
            digits[cnt++] = n % 4;
            n /= 4;
            }else{
                if(n < 8) {
                digits[cnt++] = n;
                break;
            }
            digits[cnt++] = n % 8;
            n /= 8;
            }
           
        }

         for(int i = cnt - 1; i >= 0; i--){
            System.out.print(digits[i]);
        }
    }
}