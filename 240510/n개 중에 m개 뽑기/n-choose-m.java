import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> com = combine(n,m);
        for(List<Integer> val : com){
            System.out.println(val.toString().replace("[","").replace("]","").replace(",",""));
        }
    }

    public static List<List<Integer>> combine(int n, int m){
        List<List<Integer>> result = new ArrayList();
        backtrack(result, new ArrayList<>(), n, m, 1);
        
        return result;
    }

    private static  void backtrack(List<List<Integer>> result, List<Integer> tempList, int n, int m, int start){
        if(tempList.size()  == m){
            result.add(new ArrayList<>(tempList));
        }else{
            for(int i = start; i <= n; i++){
                tempList.add(i);
                backtrack(result, tempList, n, m, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}