import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            String str = sc.next();
            if(str.equals("push")){
                //push A : 정수 A를 우선순위 큐에 넣는 연산입니다. - add();
                int num = sc.nextInt();
                q.add(-num);
            }else if(str.equals("pop")){
                //pop : 우선순위 큐에서 최댓값을 제거하고, 그 값을 출력합니다. -peek();, -poll();
                System.out.println(-q.peek());
                q.poll();
            }else if(str.equals("size")){
                //size: 우선순위 큐에 들어있는 정수의 개수를 출력합니다. - size();
                System.out.println(q.size());
            }else if(str.equals("empty")){
                //empty : 우선순위 큐가 비어있으면 1, 아니면 0을 출력합니다. - isEmpty();
                if(q.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else{
                //top : 우선순위 큐에 들어있는 값 중 최댓값을 출력합니다.
                System.out.println(-q.peek());
            }
        }
    }
}