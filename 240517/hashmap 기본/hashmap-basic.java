import java.util.Scanner;
import java.util.HashMap;


public class Main {
    public static int n;
    public static HashMap<Integer, Integer> m = new HashMap<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++){
            String s = sc.next();
            if(s.equals("add")){
                int k = sc.nextInt();
                int v = sc.nextInt();
                m.put(k, v);
            }else if(s.equals("find")){
                int k = sc.nextInt();
                if(!m.containsKey(k)){
                    System.out.println("None");
                }else{
                    System.out.println(m.get(k));
                }
            }else{
                int k = sc.nextInt();
                m.remove(k);
            }
        }

    }
}