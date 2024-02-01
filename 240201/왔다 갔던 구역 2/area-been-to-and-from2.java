import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[4001];
        int sp = 2000;
        int answer = 0;



        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            String s = sc.next();

            if(s.equals("L")){
                for(int j = sp; j < sp - n; j--){
                    arr[j]++;
                    if(j == sp + n){
                        sp = j;
                    }
                }
            }else{
                for(int j = sp; j < sp + n; j++){
                    arr[j]++;
                    if(j == sp + n){
                        sp = j;
                    }
                }

            }
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 1){
                answer++;
            }
        }

        System.out.println(answer);

    }
}