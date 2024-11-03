import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Node {
    int index, dist;
    
    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }
};

class Element implements Comparable<Element> {
    int dist, index;
    
    public Element(int dist, int index) {
        this.dist = dist;
        this.index = index;
    }

    @Override
    public int compareTo(Element e) {
        return this.dist - e.dist;
    }
};

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100000;
    public static int n, m;
    public static int a, b;
    public static ArrayList<Node>[] graph = new ArrayList[MAX_N + 1];
    public static PriorityQueue<Element> pq = new PriorityQueue<>();
    
    public static int[] redDist1 = new int[MAX_N + 1];
    public static int[] redDist2 = new int[MAX_N + 1];
    
    public static int ans = INT_MAX;
    public static void dijkstra(int k, int[] dist) {
        for(int i = 1; i <= n; i++){
            dist[i] = (int)1e8;
        }
    
        dist[k] = 0;
        pq.add(new Element(0, k));
        while(!pq.isEmpty()) {
            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();

            if(minDist != dist[minIndex]){
                continue;
            }
            for(int j = 0; j < graph[minIndex].size(); j++) {
                int targetIndex = graph[minIndex].get(j).index;
                int targetDist = graph[minIndex].get(j).dist;
                
                int newDist = dist[minIndex] + targetDist;
                if(dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.add(new Element(newDist, targetIndex));
                }
            }
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        while(m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            graph[x].add(new Node(y, z));
            graph[y].add(new Node(x, z));
        }
        dijkstra(a, redDist1);
        dijkstra(b, redDist2);
        for(int i = 1; i <= n; i++) {
            if(i == a || i == b){
                continue;
            }

            if(redDist1[i] != (int)1e8 && redDist1[b] != (int)1e8 && redDist2[i] != (int)1e8){
                ans = Math.min(ans, redDist1[i] + redDist1[b] + redDist2[i]);
            }

            if(redDist2[i] != (int)1e8 && redDist2[a] != (int)1e8 && redDist1[i] != (int)1e8){
            ans = Math.min(ans, redDist2[i] + redDist2[a] + redDist1[i]);
            }
        }

        if(ans == INT_MAX){
            ans = -1;
        }
        
        System.out.print(ans);
    }
}