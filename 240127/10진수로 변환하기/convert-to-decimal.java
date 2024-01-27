import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String n = sc.next();

        int [] binary = new int[n.length()];
        for(int i = 0; i < n.length(); i++){
            int s = Integer.parseInt(String.valueOf(n.charAt(i)));
            binary[i] = s;
        }

        int num = 0;

        for(int i = 0; i < binary.length; i++){
           num = num * 2 + binary[i];
        }
        System.out.println(num);

    }
}