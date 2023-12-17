import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxValue = 0;

        for(int i = 0; i < 10; i++){
            int a = sc.nextInt();
            if(maxValue < a){
                maxValue = a;
            }
        }
        System.out.println(maxValue);
    }
}