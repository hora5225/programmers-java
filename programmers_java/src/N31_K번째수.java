import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 * 220806
 */
public class N31_K번째수 {
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i<commands.length; i++){

            int startIndex = commands[i][0]-1;  // i
            int endIndex = commands[i][1]-1;    // j
            int getIndex = commands[i][2]-1;    // k

            //Arrays.copyOfRange
            for(int j = startIndex;j<=endIndex;j++){    // i~j 번째 까지 자름
                list.add(array[j]);
            }
            //list =  [5, 2, 6, 3]
            System.out.println(list.toString());

            Collections.sort(list); // 정렬

            //list = [2, 3, 5, 6]
            System.out.println(list);   // println 하면 자동으로 toString() 이 붙는다.

            answer[i] = list.get(getIndex); // k 번째 값을 answer[i] 에 저장
            list.clear();//다썼으니까 지워준다. 이거 안하면 만든거 뒤에 계속 붙음 아니면 포문 처음에 다시 객체 생성해줘야함

        }
        return answer;
    }   //end of solution

    public static void main(String[] args) {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        N31_K번째수 s31 = new N31_K번째수();

        System.out.println(Arrays.toString(s31.solution(array, commands)));
    }
}
