import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        // (p번째 사람, m번째 치즈, t초) 먹음
        ArrayList<int[]> eaten = new ArrayList<>();
        for (int i = 0; i < D; i++) {
            st = new StringTokenizer(br.readLine());
            eaten.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        // (p번째 사람, t초) 아픔
        HashMap<Integer, Integer> bad_condition = new HashMap<>();
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            bad_condition.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // Step1 : 상한 치즈 고르기
        ArrayList<HashSet<Integer>> gone_cheezes = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            gone_cheezes.add(new HashSet<>());
        }

        HashMap<Integer, ArrayList<int[]>> eaten_dict = new HashMap<>();
        // 아프기 전 섭취했다면 ? 주워담는다.
        for (int[] eat : eaten) {
            if (!eaten_dict.containsKey(eat[0])) {
                eaten_dict.put(eat[0], new ArrayList<>());
            }
            eaten_dict.get(eat[0]).add(new int[] {eat[1], eat[2]});
        }

        for (Map.Entry<Integer, Integer> entry : bad_condition.entrySet()) {
            int bad_p = entry.getKey();
            int bad_t = entry.getValue();

            // bad_t 이하로, bad_p의 치즈를 gone_cheezes[bad_p]에 주워담는다.
            if (eaten_dict.containsKey(bad_p)) {
                for (int[] eat : eaten_dict.get(bad_p)) {
                    if (eat[1] < bad_t) {
                        gone_cheezes.get(bad_p).add(eat[0]);
                    }
                }
            }
        }

        HashSet<Integer> candi = null;
        for (HashSet<Integer> gone_cheeze : gone_cheezes) {
            if (gone_cheeze.size() > 0) {
                if (candi == null) {
                    candi = new HashSet<>(gone_cheeze);
                } else {
                    candi.retainAll(gone_cheeze);
                }
            }
        }

        // Step2 : 먹은 사람 세기
        int max_cnt = 0;
        if (candi != null) {
            for (int i : candi) {
                int cnt = 0;
                for (ArrayList<int[]> eat_cheezes : eaten_dict.values()) {
                    for (int[] eat : eat_cheezes) {
                        if (i == eat[0]) {
                            cnt += 1;
                            break;
                        }
                    }
                }
                max_cnt = Math.max(max_cnt, cnt);
            }
        }

        System.out.println(max_cnt);
    }
}