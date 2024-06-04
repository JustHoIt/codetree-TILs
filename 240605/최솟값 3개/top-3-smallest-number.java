import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            pQ.offer(sc.nextInt());
            if(pQ.size() >= 3){
                int a = pQ.poll();
                int b = pQ.poll();
                int c = pQ.poll();


                long result = (long) a * b * c;

                System.out.println(result);
                pQ.offer(a);
                pQ.offer(b);
                pQ.offer(c);
            }else{
                System.out.println(-1);
            }
        }

    }
}