import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if(absA == absB){
                return Integer.compare(a, b);
            }else{
                return Integer.compare(absA, absB);
            }
        });

        for(int i = 0; i < n; i++){
            int num = sc.nextInt();

            if(num == 0){
                if(pQ.size() != 0){
                    System.out.println(pQ.poll());
                }else{
                    System.out.println(0);
                }
            }else{
                pQ.add(num);
            }
        }
    }
}