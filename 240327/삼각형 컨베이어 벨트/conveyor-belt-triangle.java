import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int a = 3 * n;
        int [] arr = new int[a];

        for(int i  = 0; i < a; i++){
            arr[i] = sc.nextInt();
        }

        int temp = 0;
        for(int i = 0; i < t; i++){
            temp = arr[a - 1];
            for(int j = a - 1; j >= 1; j--){
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }

        for(int i = 0; i < a; i++){
            System.out.print(arr[i] + " ");
            if((i + 1) % n == 0 ){
                System.out.println();
            }
        }
    }
}