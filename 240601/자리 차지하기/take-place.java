import java.util.Scanner;
import java.util.TreeSet;
// n 안고자하는 의자 정보
// m 의자번호(의자 개수)
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Integer>[] set = new TreeSet[m + 1];

        for(int i = 1; i <= m; i++){
            set[i] = new TreeSet<>();
        }

        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            set[a].add(i);
        }
        int cnt = 0;
        for(int i = 1; i <= m; i++){
            if(!set[i].isEmpty()){
                cnt++;
                set[i].pollFirst();
            }
        }
        System.out.println(cnt);
    }
}