import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 0; i < n; i++){
            q.add(sc.nextInt());
        }

        for(int i = 0; i < m; i++){
            int num = q.poll();
            q.add(num - 1);
        }

        System.out.println(-q.peek());
    }
}