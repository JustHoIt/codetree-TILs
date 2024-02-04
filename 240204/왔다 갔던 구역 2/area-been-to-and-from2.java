import java.util.Scanner;

public class Main{
    static int MAX_VALUE = 2001;
    static int offset = 1000;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] checked = new int[MAX_VALUE];
        int [] x1 = new int [100];
        int [] x2 = new int [100];
        int answer = 0;
        int cur = 0;

        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            String s = sc.next();

            if(s.equals("L")){
                x1[i] = cur - x;
                x2[i] = cur;
                cur -= x;
            }else{
                x1[i] = cur;
                x2[i] = cur + x;
                cur += x;
            }
        }

        for (int i = 0; i < n; i++) {
            for(int j = x1[i] + offset; j < x2[i]+offset; j++){
                checked[j]++;
            }
        }
        for (int i = 0; i < MAX_VALUE ; i++) {
            if(checked[i] >= 2){
                answer++;
            }
        }

        System.out.println(answer);

    }
}