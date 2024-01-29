import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int M = sc.nextInt();
        int [] student = new int[N]; // 학생수만큼

        for(int i= 0; i < K; i++){
            int num = sc.nextInt();

            student[num-1]++;

            if(student[num-1] >= M){
                System.out.println(num);
            }
        } 
    }
}