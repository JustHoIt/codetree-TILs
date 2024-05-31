import java.util.Scanner;
import java.util.TreeSet;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());

        for(int i = 0; i < n;  i++){
            set.add(sc.nextInt());
        }

        int cnt = 0;

        for(Integer num : set){
            System.out.print(num + " ");
            cnt++;
            if(cnt == k){
                break;
            }
        }
    }
}