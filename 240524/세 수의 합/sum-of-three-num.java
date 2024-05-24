import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }


        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                map.put(arr[i], map.get(arr[i]) - 1);
                map.put(arr[j], map.get(arr[j]) - 1);

                int tmp = arr[i] + arr[j];

                if(map.containsKey(k - tmp)){
                    ans += map.get(k - tmp);
                }

                map.put(arr[i],map.get(arr[i]) + 1);
                map.put(arr[j],map.get(arr[j]) + 1);
            }
        }

        System.out.println(ans / 3);

    }
}