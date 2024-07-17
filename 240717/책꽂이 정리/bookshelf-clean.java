import java.util.Scanner;

class Node {
	int data;
	Node prev, next;
 
	public Node(int data) {
		this.data = data;
		this.prev = this.next = null;
	}
}

public class Main {
	public static final int MAX_N = 250000;
	public static final int MAX_K = 100;
	public static Node[] nodes = new Node[MAX_N + 1];
	public static Node[] heads = new Node[MAX_K + 1];
	public static Node[] tails = new Node[MAX_K + 1];
	public static boolean empty(int i) {
		return null == heads[i];
	}
	public static void connect(Node u, Node v) {
		u.next = v;
		v.prev = u;
	}
	public static Node pop_front(int i) {
		Node ret = heads[i];

		if (null != ret) {
			heads[i] = ret.next;

			ret.next = null;

			if (null != heads[i])
				heads[i].prev = null;
			else
				tails[i] = null;
		}

		return ret;
	}

	public static Node pop_back(int i) {
		Node ret = tails[i];

		if (null != ret) {
			tails[i] = ret.prev;

			ret.prev = null;

			if (null != tails[i])
				tails[i].next = null;
			else
				heads[i] = null;
		}

		return ret;
	}

	public static void push_front(int i, Node singleton) {
		if (null == heads[i]) {
			heads[i] = tails[i] = singleton;
		} else {
			connect(singleton, heads[i]);
			heads[i] = singleton;
		}
	}

	public static void push_back(int i, Node singleton) {
		if (null == tails[i]) {
			heads[i] = tails[i] = singleton;
		} else {
			connect(tails[i], singleton);
			tails[i] = singleton;
		}
	}
	public static void move_all_front(int i, int j) {
		if (i == j || empty(i))
			return;

		if (empty(j)) {
			heads[j] = heads[i];
			tails[j] = tails[i];
		} else {
			connect(tails[i], heads[j]);
			heads[j] = heads[i];
		}
		heads[i] = tails[i] = null;
	}
	public static void move_all_back(int i, int j) {
		if (i == j || empty(i))
			return;

		if (empty(j)) {
			heads[j] = heads[i];
			tails[j] = tails[i];
		} else {
			connect(tails[j], heads[i]);
			tails[j] = tails[i];
		}
		heads[i] = tails[i] = null;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		for (int i = 1; i <= n; i++)
			nodes[i] = new Node(i);

		for (int i = 1; i < n; i++)
			connect(nodes[i], nodes[i+1]);
		for (int i = 1; i <= k; i++)
			heads[i] = tails[i] = null;
		heads[1] = nodes[1];
		tails[1] = nodes[n];

		int q = sc.nextInt();

		for (int t = 0; t < q; t++) {
			int type = sc.nextInt();
			int i = sc.nextInt();
			int j = sc.nextInt();

			if (1 == type) {
				Node node = pop_front(i);
				if (null != node)
					push_back(j, node);
			} else if (2 == type) {
				Node node = pop_back(i);
				if (null != node)
					push_front(j, node);
			} else if (3 == type) {
				move_all_front(i, j);
			} else if (4 == type) {
				move_all_back(i, j);
			}
		}

		for (int i = 1; i <= k; i++) {
			int cnt = 0;
			Node cur = heads[i];
			while (null != cur) {
				cnt++;
				cur = cur.next;
			}

			System.out.printf("%d", cnt);
			cur = heads[i];
			while (null != cur) {
				System.out.printf(" %d", cur.data);
				cur = cur.next;
			}

			System.out.println();
		}
	}
}