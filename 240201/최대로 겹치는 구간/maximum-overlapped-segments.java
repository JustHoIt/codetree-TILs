import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;

        int [] line = new int[201];
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            a += 100;
            b += 100;

            for(int j = a; j < b; j++){
                line[j]++;
            }
        }
        for(int i = 0; i < line.length; i++){
            if(line[i] > answer){
                answer = line[i];
            }
        }
        System.out.print(answer);
    }
}