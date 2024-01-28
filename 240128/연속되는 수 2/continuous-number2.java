import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        int answer = 1;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] arr = new int [N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        int cnt = 1;
        for(int i = 1; i < N; i++){
            if(arr[i] == arr[i - 1]){
                cnt++;
                answer = Math.max(cnt, answer);
            }else if(arr[i] != arr[i-1]){
                answer = Math.max(cnt, answer);
                cnt = 1;
            }


        }
        System.out.println(answer);
    }
}