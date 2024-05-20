import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> m = new HashMap<>();
        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 1; i <= n; i++){
            int num = sc.nextInt();
            m.put(i, num);
        }
        int cnt = 0;
        for(int i = 1; i < n; i++){
            for(int j = i + 1; j <= n; j++){
                int num1 = m.get(i);
                int num2 = m.get(j);
                if(num1 + num2 == k){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}