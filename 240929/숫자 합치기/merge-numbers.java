import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {    
    public static final int MAX_N = 100000;
    public static int n;
    public static int[] arr = new int[MAX_N];
    
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static int ans;

    public static void main(String[] args) {
        //이곳에 코드를 작성해 주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            pq.add(arr[i]);
        }

        while(pq.size() > 1) {
            int x1 = pq.poll();
            int x2 = pq.poll();
            ans += (x1 + x2);
            pq.add(x1 + x2);
        }

        System.out.print(ans);
    }
}