import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> m = new HashMap<>();
        int n = sc.nextInt();

        String [] arr = new String[n];

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            arr[i] = sc.next();
            if(!m.containsKey(arr[i])){
                m.put(arr[i], 1);
                max = Math.max(max, 1);
            }else{
                m.put(arr[i], m.get(arr[i]) + 1);
                max = Math.max(max, m.get(arr[i]));
            }
        }
        System.out.println(max);
    }
}