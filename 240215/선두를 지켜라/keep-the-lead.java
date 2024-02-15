import java.util.Scanner;

public class Main {
    static int n, m, maxL;
    static int MAX = 1000000;
    static int[] A = new int[MAX + 1];
    static int[] B = new int[MAX + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int tA = 1, tB = 1;

        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            for (int j = t; j > 0; j--) {
                A[tA] = A[tA - 1] + v;
                tA++;
                maxL++;
            }
        }
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            for (int j = t; j > 0; j--) {
                B[tB] = B[tB - 1] + v;
                tB++;
            }
        }
        
        char leader ='C';
        int cnt = 0;

        for(int i = 0; i < A.length; i++){
            if(A[i] > B[i]){
                if(leader == 'B'){
                    cnt++;
                }
                leader = 'A';
            }else if(A[i] < B[i]){
                if(leader == 'A'){
                    cnt++;
                }
                leader = 'B';
            }
        }
        System.out.println(cnt);

    }
}