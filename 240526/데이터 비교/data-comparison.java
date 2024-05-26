import java.util.Scanner;
import java.util.HashSet;


public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int num = sc.nextInt(); 
            set.add(num);
        }
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            if(set.contains(num)){
                arr[i] = 1;
            }else{
                arr[i] = 0;
            }
            System.out.print(arr[i] + " ");
        }

    }
}