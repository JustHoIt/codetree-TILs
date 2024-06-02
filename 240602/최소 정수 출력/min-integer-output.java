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
            if(num == 0){
                if(que.size() == 0){
                    System.out.println(0);
                }else{
                    System.out.println(que.poll());
                }
            }else{
                que.add(num);
            }
            
        }
    }
}