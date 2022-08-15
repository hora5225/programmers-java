import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 * 220815
 */
public class N36_같은숫자는싫어 {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(arr[0]);   //밑의 for문에서 i-1 부분에서 오류 안나게
        //전에꺼랑 비교해서 다르면 list에 추가
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                list.add(arr[i]);
            }
        }

        //변환
        //int[] answer = list.stream().mapToInt(i -> i).toArray();
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();//이게 위에꺼보다 약간 더 빠르다

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        N36_같은숫자는싫어 s36 = new N36_같은숫자는싫어();
        System.out.println(Arrays.toString(s36.solution(arr)));
    }
}
