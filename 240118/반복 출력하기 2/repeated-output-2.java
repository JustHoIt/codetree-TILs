import java.util.Scanner;

public class Main {
    public void solution(int a){
        if(a == 0){
            return;
        }
        solution(a - 1);
        System.out.println("HelloWorld");
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();

        T.solution(a);
        
    }
}