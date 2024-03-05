import java.util.Scanner;

public class Main {
    static int MAX = 101;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr = new int[n][2];
        int [] line = new int[MAX];
        boolean result = false;
        
        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            for(int j = arr[i][0]; j <= arr[i][1]; j++){
                line[j] += (i + 1);
            }
        }

        for(int i = 0; i < MAX; i++){
            if(line[i] == 6){
                result = true;
                break;
            }
        }
        if(result){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }
}