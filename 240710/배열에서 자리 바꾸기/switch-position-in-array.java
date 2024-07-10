import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int Q = sc.nextInt();
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        
        for (int i = 0; i < Q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            swapSubarrays(list, a, b, c, d);
        }
        
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
    
    private static void swapSubarrays(LinkedList<Integer> list, int a, int b, int c, int d) {
        List<Integer> subarray1 = extractSubarray(list, a, b);
        List<Integer> subarray2 = extractSubarray(list, c, d);
        
        int index1 = list.indexOf(a);
        int index2 = list.indexOf(c);
        
        for (int i = 0; i < subarray1.size(); i++) {
            list.set(index1 + i, subarray2.get(i));
        }
        
        for (int i = 0; i < subarray2.size(); i++) {
            list.set(index2 + i, subarray1.get(i));
        }
    }
    
    private static List<Integer> extractSubarray(LinkedList<Integer> list, int startVal, int endVal) {
        int startIndex = list.indexOf(startVal);
        int endIndex = list.indexOf(endVal);
        
        List<Integer> subarray = new ArrayList<>();
        for (int i = startIndex; i <= endIndex; i++) {
            subarray.add(list.get(i));
        }
        
        return subarray;
    }
}