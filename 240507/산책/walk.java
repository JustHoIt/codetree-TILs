import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        HashMap<String, Integer> hMap = new HashMap<>();

        for(int i = 0; i < n; i++){
            String [] clothes = sc.nextLine().split(" ");
            String type = clothes[1];
            hMap.put(type, hMap.getOrDefault(type, 0) + 1);
        }

        long result = 1;

        for(int value : hMap.values()){
            result *= (value + 1);
        }

        System.out.println(result - 1);
    }
}