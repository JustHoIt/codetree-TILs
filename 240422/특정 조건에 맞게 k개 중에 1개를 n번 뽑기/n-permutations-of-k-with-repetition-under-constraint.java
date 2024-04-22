import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static int k, n;
    public static ArrayList<Integer> selectedNums = new ArrayList<>();
    
    public static void printPermutation() {
        for(int i = 0; i < selectedNums.size(); i++){
            System.out.print(selectedNums.get(i) + " ");
        }
        System.out.println();
    }

    public static void findPermutations(int cnt) {
        if(cnt == n) {
            printPermutation();
            return;
        }

        for(int i = 1; i <= k; i++) {
            if(cnt >= 2 && 
               i == selectedNums.get(selectedNums.size() - 1) && 
               i == selectedNums.get(selectedNums.size() - 2)){
               continue;
               }

            selectedNums.add(i);
            findPermutations(cnt + 1);
            selectedNums.remove(selectedNums.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();
        
		findPermutations(0);
	}
}