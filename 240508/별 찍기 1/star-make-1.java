import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();

        if(t == 1){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= i; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }else if(t == 2){
            for(int i = n; i >= 0; i--){
                for(int j = 1; j <= i; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }else{
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n - i; j++){
                    System.out.print(" ");
                }
                
                for(int j = 1; j <= i * 2 - 1; j++){
                    System.out.print("*");
                }
                System.out.println();
            } 
        }
        
    }
}