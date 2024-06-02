import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> que = new PriorityQueue<>();
        int n = sc.nextInt();

        int [] arr = new int[n];
        int total = 0;  
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        que.add(arr[n - 1]);
        total += arr[n - 1];

        double max = Integer.MIN_VALUE;
        for(int i = n - 2; i >= 1; i--){
            que.add(arr[i]);
            total += arr[i];

            double avg = (double)(total - que.peek()) / (n - i - 1);

            max = Math.max(max, avg);
        }

        System.out.printf("%.2f", max);
    }
}