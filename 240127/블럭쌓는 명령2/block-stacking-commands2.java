import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int [] s = new int[N];
        int answer = 0;

        for(int i = 0; i < K; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            for(int j = a; j <= b; j++){
                s[j]++;
            }
        }

        for(int i = 0; i < N; i++){
            if(s[i] > answer){
                answer = s[i];
            }
        }
        System.out.print(answer);
    }
}