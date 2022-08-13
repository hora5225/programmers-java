import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42889
 * 220812
 */
public class N34_실패율 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double n = stages.length;

        TreeMap<Integer, Double> map = new TreeMap<>();
        for (int i = 0; i < N + 1; i++) {
            map.put(i + 1, 0.0);
        }
        //System.out.println(map);

        for (int stage : stages) {
            //System.out.println("map.get(stages[i] - 1) + 1 = " + map.get(stages[i] - 1));
            //System.out.println(n);
            double putValue = map.get(stage) + 1;
            map.put(stage, putValue);

            //System.out.println("map = " + map);
        }
        //System.out.println(map);

        //double[] rate = new double[N];
        List<Double> rate = new ArrayList<>();

        double temp = 0.0;
        for (int i = 1; i < N+1; i++) {
            if(n!=0.0) {
                temp = map.get(i);
                map.put(i, map.get(i) / n);
                rate.add(map.get(i));
                n -= temp;
            }
            else{
                rate.add(0.0);
            }
        }
        //System.out.println("map = " + map);
        //System.out.println("rate = " + rate);
        rate.sort(Collections.reverseOrder());
        //System.out.println("rate = " + rate);

        for (int i = 0; i < rate.size(); i++) {
            for (int j = 1; j<N+2; j++) {
                if (Objects.equals(map.get(j), rate.get(i))) {
                    answer[i] = j;
                    map.remove(j);
                    System.out.println(map);
                    break;
                }
            }
        }


//        List<Map.Entry<Integer, Double>> entryList = new LinkedList<>(map.entrySet());
//        entryList.sort(Map.Entry.comparingByValue());
//        System.out.println(entryList);
//        ArrayList<Double> list = new ArrayList<>();
//        for (int i = 1; i < N + 1; i++) {
//            list.add(map.get(i) / n);
//            n -= map.get(i);
//            System.out.println(list);
//        }
        //System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        //int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] stages = {1,1,1};
        int n = 3;
        N34_실패율 s34 = new N34_실패율();
        System.out.println(Arrays.toString(s34.solution(n, stages)));
    }
}
