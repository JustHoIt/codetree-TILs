import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt();

        int [] A = new int[n];
        int [] B = new int[n];

        for(int i = 0; i < n; i++){
            A[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            B[i] = sc.nextInt();
        }

        int cnt = 0;
        for(int i = 0; i < n - 1; i++){
            if(A[i] > B[i]){
                int a = A[i] - B[i];
                A[i+ 1] += a;
                cnt += a;
            }else if(A[i] < B[i]){
                while(true){
                    int d = 1;
                    A[i + d]--;
                    A[i]++;
                    cnt++;
                    if(A[i + d] == 0){
                        d++;
                    }
                    if(B[i] == A[i]){
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}