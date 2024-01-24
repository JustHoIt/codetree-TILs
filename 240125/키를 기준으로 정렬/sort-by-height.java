import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요..

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<People> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            People p = new People(name, height, weight);
            list.add(p);
        }

        Collections.sort(list);

        for(int i = 0; i < n; i++){
            System.out.println(list.get(i).name + " " + list.get(i).height + " " + list.get(i).weight);
        }
    }
}

class People implements Comparable<People>{
    String name;
    int height;
    int weight;
    public People(String name, int height, int weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(People o){
        int result = this.height - o.height;
        if(result > 0){
            return 1;
        }else if(result < 0){
            return -1;
        }
        return 0;
    }
}