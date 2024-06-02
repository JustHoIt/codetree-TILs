import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Main {
    public static final int MAX = 100000;
    public static int t, m;
    public static int [] arr = new int[MAX];

    public static void findMedian(){
        int median = arr[0];
        PriorityQueue<Integer> maxQ = new PriorityQueue<>();
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        System.out.print(median + " ");

        for(int i = 1; i < m; i++){
            if(i % 2 == 1){
                if(arr[i]  < median){
                    maxQ.add(-arr[i]);
                }else{
                    minQ.add(arr[i]);
                }
            }else{
                int cand;
                if(maxQ.size() > minQ.size()){
                    cand = -maxQ.poll();
                }else{
                    cand = minQ.poll();
                }
                int [] nums = new int[]{median, arr[i], cand};
                Arrays.sort(nums);

                maxQ.add(-nums[0]);
                median = nums[1];
                minQ.add(nums[2]);

                System.out.print(median + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc= new Scanner(System.in);
        t = sc.nextInt();
        while(t-- > 0){
            m = sc.nextInt();
            for(int i = 0; i < m; i++){
                arr[i] = sc.nextInt();
            }
            findMedian();
        }
    }
}