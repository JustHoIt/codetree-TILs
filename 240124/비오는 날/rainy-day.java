import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner sc = new Scanner(System.in);
        ArrayList<WeatherInformation> list = new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            String day = sc.next();
            String dayOfTheWeek = sc.next();
            String weather = sc.next();
            WeatherInformation wInfo = new WeatherInformation(day, dayOfTheWeek, weather);
            list.add(wInfo);
        }
        Collections.sort(list);

        for(int i = 0; i < n; i++){
            if(list.get(i).weather.equals("Rain")){
            System.out.println( list.get(i).day + " " + list.get(i).dayOfTheWeek + " " + list.get(i).weather);
            break;
            }
        }
    }
}

class WeatherInformation implements Comparable<WeatherInformation>{
    String day;
    String dayOfTheWeek;
    String weather;
    public WeatherInformation(String day, String dayOfTheWeek, String weather){
        this.day = day;
        this.dayOfTheWeek = dayOfTheWeek;
        this.weather = weather;
    }
    @Override
    public int compareTo(WeatherInformation o){
        return this.day.compareTo(o.day);
    }
}