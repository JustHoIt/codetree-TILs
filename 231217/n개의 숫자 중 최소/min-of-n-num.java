import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minValue = Integer.MAX_VALUE;
        int count = 0;
        int n = sc.nextInt();

        int [] arr = new int[n];
        

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            if(minValue > arr[i]){
                minValue = arr[i];
            }
        }
        for(int i = 0; i < n; i++){
            if(arr[i] == minValue){
                count++;
            }
        }
        System.out.println(minValue+ " " + count);
    }
}