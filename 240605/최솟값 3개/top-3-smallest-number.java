import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        List<Integer> qlist;

        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            pQ.add(sc.nextInt());
            long ans = 1;
            if(pQ.size() >= 3){
                qlist = new ArrayList<>(pQ);
                qlist.sort(Integer::compare);
                for(int j = 0; j < 3; j++){
                    ans = ans * qlist.get(j);
                }
                System.out.println(ans);
            }else{
                System.out.println(-1);
            }
        }

    }
}