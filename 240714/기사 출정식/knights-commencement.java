import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static final int MAXN = 100002;

    static class Node {
        int val;
        Node prev, next;

        Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    static Node[] nodes = new Node[MAXN];
    static HashMap<Integer, Integer> nodeId = new HashMap<>();
    
    static void connect(Node s, Node e) {
        if (s != null) s.next = e;
        if (e != null) e.prev = s;

    }
    static void pop(Node u) {
        connect(u.prev, u.next);
        u.prev = u.next = null;
    }

    public static void main(String[] args) {
        //코드를 여기에 작성해주세요.
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int knightNum = sc.nextInt();
        nodeId.put(knightNum, 1);
        nodes[1] = new Node(knightNum);
        for (int i = 2; i <= n; i++) {
            knightNum = sc.nextInt();
            nodeId.put(knightNum, i);
            nodes[i] = new Node(knightNum);
            connect(nodes[i - 1], nodes[i]);
            if (i == n){ 
                connect(nodes[n], nodes[1]);
            }
        }

        while (m-- > 0) {
            knightNum = sc.nextInt();
            System.out.println(nodes[nodeId.get(knightNum)].next.val + " " + nodes[nodeId.get(knightNum)].prev.val);
            pop(nodes[nodeId.get(knightNum)]);
        }
        
    }
}