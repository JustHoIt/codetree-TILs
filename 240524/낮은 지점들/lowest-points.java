import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map  = new HashMap<>();

        int n = sc.nextInt();
        int cnt = n;

        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(map.containsKey(x)){
                y = Math.min(map.get(x), y);
                map.put(x, y);
                cnt--;
            }else{
                map.put(x, y);
            }
        }
        int ans = 0;
        for (int value : map.values()) {
            ans += value;
        }

        System.out.println(ans);
    }
}