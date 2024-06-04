import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static class Person implements Comparable<Person> {
        int idx;
        int arrivalTime;
        int stayTime;

        public Person(int idx, int arrivalTime, int stayTime) {
            this.idx = idx;
            this.arrivalTime = arrivalTime;
            this.stayTime = stayTime;
        }

        @Override
        public int compareTo(Person other) {
            return Integer.compare(this.idx, other.idx);
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Person[] people = new Person[n];
        
        for (int i = 0; i < n; i++) {
            int arrivalTime = sc.nextInt();
            int stayTime = sc.nextInt();
            people[i] = new Person(i, arrivalTime, stayTime);
        }
        Arrays.sort(people, Comparator.comparingInt(p -> p.arrivalTime));
        
        int[] waitingTime = new int[n];
        PriorityQueue<Person> waitingPQ = new PriorityQueue<>();
        int exitTime = 0; 

        for (Person person : people) {
            int idx = person.idx;
            int a = person.arrivalTime;
            int t = person.stayTime;
            while (a > exitTime && !waitingPQ.isEmpty()) {
                Person curPerson = waitingPQ.poll();
                int curIdx = curPerson.idx;
                int curA = curPerson.arrivalTime;
                int curT = curPerson.stayTime;

                waitingTime[curIdx] = exitTime - curA; 
                exitTime += curT; 
            }

            if (a > exitTime) {
                exitTime = a + t;
                waitingTime[idx] = 0;
            } else {
                waitingPQ.add(person);
            }
        }

        while (!waitingPQ.isEmpty()) {
            Person curPerson = waitingPQ.poll();
            int curIdx = curPerson.idx;
            int curA = curPerson.arrivalTime;
            int curT = curPerson.stayTime;

            waitingTime[curIdx] = exitTime - curA;
            exitTime += curT;
        }

        int maxWaitTime = Arrays.stream(waitingTime).max().orElse(0);
        System.out.println(maxWaitTime);
    }
}