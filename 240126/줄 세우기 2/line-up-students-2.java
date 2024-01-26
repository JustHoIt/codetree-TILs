import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];
        for(int i = 0; i < n; i++){
            int height = sc.nextInt();
            int weight = sc.nextInt();
            students[i] = new Student(height, weight, i+1);
        }

        Arrays.sort(students);

        for(int i = 0 ; i < n; i++){
            System.out.println(students[i].height + " " + students[i].weight + " " + students[i].idx);
        }
    }
}




class Student implements Comparable<Student>{
    int height;
    int weight;
    int idx;
    public Student(int height, int weight, int idx){
        this.height = height;
        this.weight = weight;
        this.idx = idx;
    }

    @Override
    public int compareTo(Student o){
        if(height == o.height){
            return o.weight - this.weight;
        }
        return this.height - o.height;
    }
}