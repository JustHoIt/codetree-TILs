import java.util.Scanner;

public class Main {
    static int MAX_VALUE = 100000000;
    static char [] line = new char[MAX_VALUE + 1];

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int maxNum = 1;
        for (int i = 0; i < N; i++) {
            int l = sc.nextInt();
            line[l] = sc.next().charAt(0);
        }
        for(int i = 1; i <= K; i++){
            int num = 0;
            if(line[i] == 'G'){
                num = 1;
            } else if (line[i] == 'H') {
                num = 2;
            }
            maxNum += num;
        }
        System.out.println(1);
        System.out.println(maxNum);
    }
}