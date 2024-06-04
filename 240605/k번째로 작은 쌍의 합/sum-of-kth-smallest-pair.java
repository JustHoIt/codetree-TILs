import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args){
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int [] a = new int[n];
        int [] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());




        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { 
                int now = a[i] + b[j];
                if(pq.size() >= k && !pq.isEmpty() && now > pq.peek()) {
                    break;
                }
                pq.add(now);
                if(pq.size() > k) pq.poll();
            }
        }
        
        System.out.println(pq.peek());
    }
}