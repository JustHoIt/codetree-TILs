import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int answer = 0;
        int cnt = 0;
        
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            if(arr[i] > t){
                cnt++;
            }else{
                cnt = 0;
            }
            answer = Math.max(cnt, answer);
        }
        System.out.println(answer);

        
    }
}