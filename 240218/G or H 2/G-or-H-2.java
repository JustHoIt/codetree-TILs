import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 100;
    
    public static int n, k;
    public static int[] arr = new int[MAX_NUM + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            
            if(c == 'G')
                arr[x] = 1;
            else
                arr[x] = 2;
        }
        
        int maxLen = 0;
        for(int i = 0; i <= MAX_NUM; i++) {
            for(int j = i + 1; j <= MAX_NUM; j++) {
                if(arr[i] == 0 || arr[j] == 0)
                    continue;
                
                int cntG = 0;
                int cntH = 0;
                
                for(int k = i; k <= j; k++) {
                    if(arr[k] == 1)
                        cntG++;
                    if(arr[k] == 2)
                        cntH++;
                }

                if(cntG == 0 || cntH == 0 || cntG == cntH) {
                    int len = j - i;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
                            
        System.out.print(maxLen);
    }
}