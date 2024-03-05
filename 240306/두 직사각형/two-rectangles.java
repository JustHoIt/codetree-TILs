import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int [][] coordinate =  new int [101][101];

        int [][] arr = new int[4][2];

        for(int i = 0; i < 4; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        boolean result = false;

        for(int i = arr[0][0]; i <= arr[1][0]; i++){
            for(int j  = arr[0][1]; j <= arr[1][1]; j++){
                coordinate[i][j]++;
            }
        }

        for(int i = arr[2][0]; i <= arr[2][0]; i++){
            for(int j  = arr[3][1]; j <= arr[3][1]; j++){
                if(coordinate[i][j] == 1){
                    result = true;
                    break;
                }
            }
        }


        if(result){
            System.out.println("overlapping");
        }else{
            System.out.println("nonoverlapping");
        }
    }
}