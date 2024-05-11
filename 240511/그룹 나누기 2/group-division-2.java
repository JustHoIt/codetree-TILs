import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        
        int first = arr[arr.length - 1];
        int second = arr[arr.length - 2];
        int max = 0;
        if(n % 2 == 0){ //짝수 일때
            max = first * (n / 2) + second * (n / 2);
        }else{
            max = first * (n / 2 + 1) + second * (n / 2);
        }

        System.out.println(max);
    }
}