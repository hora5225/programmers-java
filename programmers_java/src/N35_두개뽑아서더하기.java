import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/68644
 * 220815
 */
public class N35_두개뽑아서더하기 {
    public int[] solution(int[] numbers) {

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i]+ numbers[j]);
            }
        }
        System.out.println(set);
        int[] answer = new int[set.size()];
        answer = set.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }   //end of solution

    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        int[] numbers2 = {5,0,2,7};
        N35_두개뽑아서더하기 s35 = new N35_두개뽑아서더하기();
        System.out.println(Arrays.toString(s35.solution(numbers)));
    }
}
