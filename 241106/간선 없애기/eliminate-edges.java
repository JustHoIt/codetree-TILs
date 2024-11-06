import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair {
    int x, y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
};

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
    public static final int MAX_N = 1000;
    public static int n, m;
    public static ArrayList<Node>[] graph = new ArrayList[MAX_N + 1];
    public static PriorityQueue<Element> pq = new PriorityQueue<>();
    
    public static int[] dist = new int[MAX_N + 1];
    public static int[] path = new int[MAX_N + 1];
    
    public static int ans;
    public static void dijkstra(Pair removedEdge) {

        for(int i = 1; i <= n; i++){
            dist[i] = (int)1e9;
        }

        dist[1] = 0;
        pq.add(new Element(0, 1));

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

                if((removedEdge.x == minIndex && removedEdge.y == targetIndex) ||
                   (removedEdge.x == targetIndex && removedEdge.y == minIndex)){
                   continue;
                }
                
                int newDist = dist[minIndex] + targetDist;
                if(dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.add(new Element(newDist, targetIndex));
                    path[targetIndex] = minIndex;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

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
        dijkstra(new Pair(-1, -1));

        int idx = n;
        ArrayList<Integer> vertices = new ArrayList<>();
        vertices.add(idx);
        while(idx != 1) {
            idx = path[idx];
            vertices.add(idx);
        }

        int origDist = dist[n];
        for(int i = vertices.size() - 1; i >= 1; i--) {
            int x = vertices.get(i);
            int y = vertices.get(i - 1);
            dijkstra(new Pair(x, y));
            if(dist[n] != origDist){
                ans++;
            }
        }

        System.out.print(ans);
    }
}