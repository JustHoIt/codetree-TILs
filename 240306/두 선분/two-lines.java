import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc= new Scanner(System.in);
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();

        int x3 = sc.nextInt();
        int x4 = sc.nextInt();

        boolean result = false;

        int [] blocks = new int [101];

        for(int i = x1; i <= x2; i++){
            blocks[i]++;
        }
        for(int i = x3; i <= x4; i++){
            if(blocks[i] == 1){
                result = true;  
                break;
            }
        }

        if(result){
            System.out.println("intersecting");
        }else{
             System.out.println("nonintersecting");
        }
    }
}