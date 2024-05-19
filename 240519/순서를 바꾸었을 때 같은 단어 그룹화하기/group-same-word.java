import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

public class Main {
    public static int n;
    public static HashMap<String, Integer> wordMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            String inputStr = sc.next();
            char tempArray[] = inputStr.toCharArray();
            Arrays.sort(tempArray);
            inputStr = new String(tempArray);
            
            if(!wordMap.containsKey(inputStr)){
                wordMap.put(inputStr, 1);
            }else{
                wordMap.put(inputStr, wordMap.get(inputStr) + 1);
            }       
        }
        int maxVal = 0;
        for(String key : wordMap.keySet()) {
            maxVal = Math.max(maxVal, wordMap.get(key));
        }
        System.out.print(maxVal);
    }
}