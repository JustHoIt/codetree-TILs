import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 100000;

    public static void main(String[] args) {
        //이곳에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n;
        int[] price = new int[MAX_NUM];
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            price[i] = sc.nextInt();
        }
        int maxProfit = 0;
        int minPrice = price[0];
        for(int i = 0; i < n; i++) {
            int profit = price[i] - minPrice;
            
            if(profit > maxProfit){
                maxProfit = profit;
            }
            
            if(minPrice > price[i]){
                minPrice = price[i];
            }
        }

        System.out.print(maxProfit);
    }
}