import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minValue = Integer.MAX_VALUE;
        int count = 0;
        int [] arr = new int[10];

        for(int i = 0; i < 10; i++){
            arr[i] = sc.nextInt();
            if(minValue > arr[i]){
                minValue = arr[i];
            }
        }
        for(int i = 0; i < 10; i++){
            if(arr[i] == minValue){
                count++;
            }
        }
        System.out.println(minValue+ " " + count);
    }
}