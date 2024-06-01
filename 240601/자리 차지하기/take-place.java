import java.util.Scanner;
import java.util.TreeSet;
// n 안고자하는 의자 정보
// m 의자번호(의자 개수)
public class Main {
    public static final int MAX = 1000000;

    public static int n, m;
    public static int[] arr = new int[MAX];

    public static  TreeSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 1; i <= m; i++){
            set.add(i);   
        }

        int cnt = 0;

        for(int i = 0; i < n; i++){
            if(set.floor(arr[i]) != null) {
                int num = set.floor(arr[i]);
                set.remove(num);
                cnt++;
            }else{
                break;
            }
        }

        System.out.println(cnt);
    }
}