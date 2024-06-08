import java.util.Scanner;

public class Main {
    static int n, m;
    static int [] arr;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < m; i++){
            int target = sc.nextInt();
            int lowerBound = lowerBound(target);
            int upperBound = upperBound(target);

            System.out.println(upperBound - lowerBound);
        }
    }

    static int lowerBound(int target){
        int begin = 0;
        int end = n;


        while(begin < end){
            int mid = (begin + end) / 2;

            if(target <= arr[mid]){
                end = mid;
            } else{
                begin = mid + 1;
            }
        }

        return begin;
    }

    static int upperBound(int target){
        int begin = 0;
        int end = n;


        while(begin < end){
            int mid = (begin + end) / 2;

            if(target >= arr[mid]){
                begin = mid + 1;
            } else{
                end = mid;
            }
        }

        return begin;
    }
}