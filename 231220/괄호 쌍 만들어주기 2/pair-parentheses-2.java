import java.util.Scanner;

public class Main {
    public int solution(String s){
        int answer = 0;


        char [] c = s.toCharArray();
        int n = c.length;
        for(int i = 0; i < n; i++ ){
            for(int j = i +2; j < n - 1; j++){
                if(c[i] =='(' && c[i+1] == '(' &&c[j] ==')' && c[j+1] == ')'){
                    answer++;
                }
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(T.solution(s));
    }
}