import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int Tmax = scanner.nextInt();
        int[] d = new int[N];
        
        for (int i = 0; i < N; i++) {
            d[i] = scanner.nextInt();
        }
        
        int left = 1, right = N;
        int answer = N;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (solution(d, N, Tmax, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
    
    public static boolean solution(int[] d, int N, int Tmax, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int curTime = 0;
        
        for (int i = 0; i < N; i++) {
            if (pq.size() == K) {
                curTime = pq.poll();
            }
            if (curTime + d[i] > Tmax) {
                return false;
            }
            pq.add(curTime + d[i]);
        }
        
        return true;
    }
}