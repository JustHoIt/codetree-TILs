import java.util.Scanner;
import java.util.TreeSet;
import java.util.HashMap;

class Pair {
    int a, b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Main {    
    public static final int MAX_NUM = 100000;
    public static int n, q;
    public static int[] arr = new int[MAX_NUM];
    public static Pair[] queries = new Pair[MAX_NUM];
    
    public static TreeSet<Integer> nums = new TreeSet<>();
    public static HashMap<Integer, Integer> mapper = new HashMap<>();

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt();

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        for(int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            queries[i] = new Pair(a, b);
        }

        for(int i = 0; i < n; i++){
            nums.add(arr[i]);
        }

        int cnt = 1;

        for(Integer num : nums) {
            mapper.put(num, cnt);
            cnt++;
        }

        for(int i = 0; i < q; i++) {
            int a = queries[i].a;
            int b = queries[i].b;

            int newA = mapper.get(a);
            int newB = mapper.get(b);

            System.out.println(newB - newA + 1);
        }
    }
}