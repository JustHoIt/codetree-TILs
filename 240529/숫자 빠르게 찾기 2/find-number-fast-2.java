import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    static int MAX = 1000000000;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            set.add(num);
        }

        for(int i = 0; i < m; i++){
            int num = sc.nextInt();

            if(set.ceiling(num) != null){
                int a = set.ceiling(num);
                System.out.println(a);
            }else{
                System.out.println(-1);
            }
        }
    }
}