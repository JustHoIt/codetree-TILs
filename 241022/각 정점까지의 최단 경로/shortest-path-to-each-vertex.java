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
    public static final int MAX_N = 20000;
    public static int n, m, k;
    public static ArrayList<Node>[] graph = new ArrayList[MAX_N + 1];
    public static PriorityQueue<Element> pq = new PriorityQueue<>();
    
    public static int[] dist = new int[MAX_N + 1];

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

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

        for(int i = 1; i <= n; i++){
            dist[i] = (int)1e9;
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
        for(int i = 1; i <= n; i++) {
            if(dist[i] == (int)1e9){
                System.out.println(-1);
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}