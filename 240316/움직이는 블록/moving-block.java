import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] arr = new int[n];

        int avg = 0;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            avg += arr[i];
        }

        avg = avg / n;
        int move = 0;
        for(int i = 0; i < n; i++){
            if(avg > arr[i]){
                move += (avg - arr[i]);
            }
        }
        System.out.println(move);
    }
}