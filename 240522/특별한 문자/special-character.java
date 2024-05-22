import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        HashMap<Character, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        // String s = sc.next();
        String ans = "None";
        char[] ch = sc.next().toCharArray();

        for(char c : ch){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : ch){
            if(map.get(c) == 1){
                ans = String.valueOf(c);
                break;
            }
        }

        System.out.println(ans);
    }
}