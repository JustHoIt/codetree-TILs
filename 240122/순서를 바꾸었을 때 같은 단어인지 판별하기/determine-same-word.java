import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String answer = "Yes";
        String s1 = sc.next();
        String s2 = sc.next();

        char [] c1 = s1.toCharArray();
        char [] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);
        if(c1.length != c2.length){
            answer = "No";
        }
        if(answer.equals("Yes")){
            for(int i = 0; i < c1.length; i++){
                if(c1[i] != c2[i]){
                    answer = "No";
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}