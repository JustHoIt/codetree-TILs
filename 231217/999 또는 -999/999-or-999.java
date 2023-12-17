import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int n = 0;


        while(true){
            n = sc.nextInt();
            if(n == 999 || n == -999){
                break;
            }
            if(minValue > n){
                minValue = n;
            }
            if(maxValue < n){
                maxValue = n;
            }
        }
        System.out.println(maxValue + " " + minValue);
    }
}