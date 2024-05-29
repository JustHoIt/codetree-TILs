import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 1; i <= m; i++){
            set.add(i);
        }

        for(int i = 0; i < n; i++){
            int num = sc.nextInt();

            set.remove(num);
            
            System.out.println(set.last());
        }
    }
}