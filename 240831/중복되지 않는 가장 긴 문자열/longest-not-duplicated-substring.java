import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static final int MAX_N = 100000;
    
    public static int n;
    public static String word;
    public static HashMap<Character, Integer> countArray = new HashMap<>();

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        word = sc.next();
        n = word.length();
        
        word = "#" + word;
        int ans = 0;
        
        int j = 0;
        for(int i = 1; i <= n; i++) {
            while(j + 1 <= n && countArray.getOrDefault(word.charAt(j + 1), 0) != 1) {
                char c = word.charAt(j + 1);
                countArray.put(c, countArray.getOrDefault(c, 0) + 1);
                j++;
            }
            ans = Math.max(ans, j - i + 1);
            countArray.put(word.charAt(i), countArray.get(word.charAt(i)) - 1);
        }

        System.out.print(ans);
    }
}