import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 1, cnt = 1;

        int [] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        String yn = "N";

        for(int i = 1; i < N; i++){
            if(i  >=  1 && arr[i] * arr[i - 1] > 0){
                cnt ++;
            }else{
                cnt = 1;
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}