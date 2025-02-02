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
    public static ArrayList<Node>[] graph = new ArrayList[MAX_N + 1];
    public static PriorityQueue<Element> pq = new PriorityQueue<>();
    public static int[] dist = new int[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        while(m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            graph[x].add(new Node(y, z));
            graph[y].add(new Node(x, z));
        }
        
        for(int i = 1; i <= n; i++) {
            dist[i] = (int)1e9;
        }

        dist[1] = 0;
        pq.add(new Element(0, 1));
        int ans = 0;

        while(!pq.isEmpty()) {
            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();

            if(visited[minIndex]) {
                continue;
            }

            visited[minIndex] = true;
            ans += minDist;

            for(int j = 0; j < graph[minIndex].size(); j++) {
                int targetIndex = graph[minIndex].get(j).index;
                int targetDist = graph[minIndex].get(j).dist;
                
                int newDist = targetDist;
                if(dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.add(new Element(newDist, targetIndex));
                }
            }
        }

        System.out.print(ans);
    }
}
