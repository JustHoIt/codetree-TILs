import java.util.Scanner;
public class Main {
    
    public int solution(int n, String s){
        char [] a = s.toCharArray();
        int answer  = 0;

        for(int i = 0; i < n - 2; i++){
            for(int j = i+1; j < n - 1; j++){
                for(int k = j + 1; k < n; k++){
                    if(a[i] == 'C' && a[j] == 'O' && a[k] == 'W'){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        Main T = new Main();
        int n = sc.nextInt();
        String s = sc.next();

        System.out.println(T.solution(n, s));


    }
}