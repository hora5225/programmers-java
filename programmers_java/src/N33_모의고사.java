import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 * 220810
 */
public class N33_모의고사 {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] patA = {1, 2, 3, 4, 5};
        int[] patB = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] patC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int j = 0;

        //ansA 생성
        ArrayList<Integer> ansA = new ArrayList<>();
        for (int i = 0; i < answers.length; i++) {
            ansA.add(patA[j++]);
            if (j == patA.length) {
                j = 0;
            }
        }

        //ansB생성
        ArrayList<Integer> ansB = new ArrayList<>();
        j = 0;
        for (int i = 0; i < answers.length; i++) {
            ansB.add(patB[j++]);
            if (j == patB.length) {
                j = 0;
            }
        }

        //ansC생성
        ArrayList<Integer> ansC = new ArrayList<>();
        j = 0;
        for (int i = 0; i < answers.length; i++) {
            ansC.add(patC[j++]);
            if (j == patC.length) {
                j = 0;
            }
        }

        int cntA = 0;
        int cntB = 0;
        int cntC = 0;

        //만들어놓은 학생들이 쓴 답안리스트와 진짜 답안을 하나하나 비교해서, 맞출 때마다 cnt++
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == ansA.get(i)) {
                cntA++;
            }
            if (answers[i] == ansB.get(i)) {
                cntB++;
            }
            if (answers[i] == ansC.get(i)) {
                cntC++;
            }
        }

        //정답 개수 모아서 리스트생성
        ArrayList<Integer> cnt = new ArrayList<>(Arrays.asList(cntA, cntB, cntC));
        //int max = cnt.stream().mapToInt(i->i).max().getAsInt();
        int max = Collections.max(cnt);
        //int max = Math.max((Math.max(cntA, cntB)), cntC);   //최고 정답자의 정답 수 찾기
        //System.out.println(max);

        ArrayList<Integer> ans = new ArrayList<>();

        //
        for(int i = 0; i<3; i++){
            if (max == cnt.get(i)) {
                ans.add(i+1);
            }
        }

        //int[] 타입인 answer에 List<Integer>인 ans 넣어주기. 한참 고민했다 ㅠ
        answer = ans.stream().mapToInt(i->i).toArray();

        System.out.println(answer);

        return answer;
    }//end of solution

    public static void main(String[] args) {
        N33_모의고사 s33 = new N33_모의고사();
        //int[] answers = {1, 3, 2, 4, 2};
        int[] answers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(s33.solution(answers)));
    }
}
