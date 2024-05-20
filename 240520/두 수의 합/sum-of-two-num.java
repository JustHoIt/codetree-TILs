import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> m = new HashMap<>();
        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            m.put(num, m.getOrDefault(num,0) + 1);
        }

        long cnt = 0;
        for(Integer num : m.keySet()){
            int c = k - num;

            if(num == c){
                cnt += (long)m.get(num) * (m.get(num) - 1); 
            }else if(m.containsKey(c)){
                cnt += (long)m.get(num) * m.get(c);
            }
        }
        System.out.println(cnt / 2);
    }
}