import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] answer = new int[n];
        Number[] numbers = new Number[n]; 

        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            numbers[i] = new Number(num, i);
        }

        Arrays.sort(numbers);

        for(int i = 0; i < n; i++){
            answer[numbers[i].idx] = i + 1;
        }

        for(int i = 0; i < n; i++){
            System.out.print(answer[i] + " ");
        }
    }
}

class Number implements Comparable<Number>{
    int num;
    int idx;
    public Number(int num, int idx){
        this.num = num;
        this.idx = idx;
    }

    @Override
    public int compareTo(Number o){
        
        if(num != o.num){
            return num - o.num;
        }
        return idx - o.idx;
    }
}