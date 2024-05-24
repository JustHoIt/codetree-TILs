import java.util.TreeMap;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> m = new TreeMap<>();


        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            String s = sc.next();
            if(s.equals("add")){
                int a = sc.nextInt();
                int b = sc.nextInt();
                m.put(a, b);
            }else if(s.equals("find")){
                int a = sc.nextInt();
                if(m.containsKey(a)){
                    System.out.println(m.get(a));
                }else{
                    System.out.println("None");
                }
            }else if(s.equals("print_list")){
                if(m.size() != 0){
                    Iterator<Entry<Integer, Integer>> it = m.entrySet().iterator();
                    while(it.hasNext()){
                        Entry<Integer, Integer> entry = it.next();
                        System.out.print(entry.getValue()+ " ");
                    }
                }else{
                    System.out.println("None");
                }
                System.out.println();
            }else{
                int a = sc.nextInt();
                m.remove(a);
            }
        }
    }
}