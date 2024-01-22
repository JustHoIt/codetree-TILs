import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n  = sc.nextInt();

        int [] arr1 = new int[n];
        int [] arr2 = new int[n];
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        String s = "Yes";
        for(int i = 0; i < n; i++){
            if(arr1[i] != arr2[i]){
                s = "No";
                break;
            }
        }
        System.out.println(s);
    }
}