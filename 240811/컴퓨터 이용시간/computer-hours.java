import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Pair {
    int x1, x2;
    public Pair(int x1, int x2) { 
        this.x1 = x1; 
        this.x2 = x2; 
    }
}

class Tuple implements Comparable<Tuple> { 
    int x, v, index;
    public Tuple(int x, int v, int index) { 
        this.x = x; 
        this.v = v;
        this.index = index; 
    }
    @Override
    public int compareTo(Tuple b) {
        if(x != b.x) return x - b.x;
        if(v != b.v) return v - b.v;
        return index - b.index;
    }
}

public class Main {
    public static final int MAX_N = 100000;
    public static int n;
    public static int ans;
    
    public static ArrayList<Pair> segments = new ArrayList<>();
    public static int[] assignedNums = new int[MAX_N];
    
    public static PriorityQueue<Integer> computers = new PriorityQueue<>();

    public static void main(String[] args) {
        //여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            segments.add(new Pair(x1, x2));
        }
        for(int i = 1; i <= n; i++){
            computers.add(i);
        }

        ArrayList<Tuple> points = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            int x1 = segments.get(i).x1;
            int x2 = segments.get(i).x2;
            points.add(new Tuple(x1, +1, i)); 
            points.add(new Tuple(x2, -1, i));
        }

        Collections.sort(points);

        for(int i = 0; i < 2 * n; i++) {
            int x = points.get(i).x;
            int v = points.get(i).v;
            int index = points.get(i).index;

            if(v == +1) {
                int computerNum = computers.poll();
                assignedNums[index] = computerNum;
            } else {
                int computerNum = assignedNums[index];
                computers.add(computerNum);
            }
        }
        
        for(int i = 0; i < n; i++){
            System.out.print(assignedNums[i] + " ");
        }
    }
}