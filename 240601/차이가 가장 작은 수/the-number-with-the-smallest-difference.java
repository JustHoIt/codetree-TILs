import java.util.Scanner;
import java.util.TreeSet;
// n 정수 개수
// m 최소 차이
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [] arr = new int[n];

        TreeSet<Integer> set = new TreeSet<>();
        int diff = Integer.MAX_VALUE;


        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            int cur = arr[i];
            Integer h = set.ceiling(cur + m);
            Integer l = set.floor(cur - m);

            if(h != null){
                diff = Math.min(diff, h - cur);
            }

            if(l != null){
                diff = Math.min(diff, cur - l);
            }

            set.add(cur);
        }

        if(diff == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(diff);
        }
    }
}