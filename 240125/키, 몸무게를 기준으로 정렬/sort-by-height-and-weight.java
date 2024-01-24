import java.util.Scanner;
import java.util.Arrays;

public class Main {
     public static void main(String[] args) {
        // 여기에 코드를 작성해주세요..

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        People[] peoples = new People[n];

        for(int i = 0; i < n; i++){
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            peoples[i] = new People(name, height, weight);
        }

        Arrays.sort(peoples);

        for(int i = 0; i < n; i++){
           System.out.println(peoples[i].name + " " + peoples[i].height + " " + peoples[i].weight);
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
        if(this.height == o.height){
            return o.weight - this.weight;
        }
        return this.height - o.height;

    }
}