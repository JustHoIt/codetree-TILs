import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> que = new PriorityQueue<>();
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            que.add(-num);
        }
        int cnt = 0;
        while(que.size() > 1){

            int diff = -que.poll();
            diff = diff - (-que.poll());

            if(diff != 0){
                que.add(-diff);
            }
        }

        if(!que.isEmpty()){
            System.out.println(-que.peek());
        }else{
            System.out.println(-1);
        }
    }
}