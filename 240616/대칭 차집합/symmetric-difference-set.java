import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> hs = new HashSet<>();

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a + b;

        for(int i = 0; i < a; i++){
            hs.add(sc.nextInt());
        }

        for(int i = 0; i < b; i++){
            int num = sc.nextInt();
            if(hs.contains(num)){
                c -= 2;
            }
        }

        System.out.println(c);
    }
}