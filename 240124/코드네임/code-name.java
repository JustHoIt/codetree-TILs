import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc =new Scanner(System.in);
        ArrayList<Agent> list = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            String codename = sc.next();
            int score = sc.nextInt();
            Agent a = new Agent(codename, score);
            list.add(a);
        }
        Collections.sort(list);

        System.out.println(list.get(0).codename + " " + list.get(0).score);
    }
}

class Agent implements Comparable<Agent>{
    String codename;
    int score;
    
    public Agent(String codename, int score){
        this.codename = codename;
        this.score = score;
    }

    @Override
    public int compareTo(Agent o){
        if(this.score > o.score){
            return 1;
        }else if(this.score < o.score){
            return -1;
        }
        return 0;
    } 
}