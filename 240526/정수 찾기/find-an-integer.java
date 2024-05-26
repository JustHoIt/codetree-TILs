import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            set.add(num);
        }
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            if(set.contains(num)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}