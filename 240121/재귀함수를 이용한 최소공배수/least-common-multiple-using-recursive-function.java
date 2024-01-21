import java.util.Scanner;

public class Main {
    static int [] arr;
    static int answer = 1;
    static int n, g;
    static int ck;
    public static int solution(int a, int b){ 
        for(int i = 2; i < arr.length; i++){
            g = gcd(answer,arr[i]);
            answer = (answer * arr[i] / g);
        }
        return answer;
    }

    public static int gcd(int a, int b){
        if(a % b == 0){
            return b;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            
        }
        if(n == 1){
            System.out.println(arr[0]);
        }else{
            answer = arr[0] * arr[1] / gcd(arr[0], arr[1]);
            System.out.println(solution(0, 1));
        }
    }
}