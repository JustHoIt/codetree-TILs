import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int n;
    static boolean[] visited;
    public static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc= new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n + 1];

        solution(0);
    }

    public static void solution(int currNum){
        if(currNum == n){
            for(int i = 0; i < answer.size(); i++){
                System.out.print(answer.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for(int i =  1; i <= n; i++){
            if(visited[i]){
                continue;
            }

            visited[i] = true;
            answer.add(i);

            solution(currNum + 1);
            answer.remove(answer.size() - 1);
            visited[i] = false;
        }
    }
}