import java.util.Scanner;

public class Main {
    public static final int MAX_N = 10;
    
    public static int n;
    public static String[] arr = new String[MAX_N];

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            arr[i] = sc.next();
        }

        int cnt = 0;
        for(int i = n - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--) {
                if(arr[i].charAt(j) == '1') {
                    cnt++;
                    for(int k = 0; k <= i; k++){
                        for(int l = 0; l <= j; l++){
                            arr[k] = arr[k].substring(0, l) + (char)((int)'0' + (int)'1' - (int)arr[k].charAt(l)) + arr[k].substring(l + 1);
                        }
                    }
                }
            }
        }

        System.out.print(cnt);
        
    }
}