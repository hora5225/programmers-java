import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862?language=java
 * 220801
 */
public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] students = new int[n];

        //도둑맞은 사람은 -1
        for (int l : lost)
            students[l-1]--;

        //reserve인 사람은 +1 해준다
        for (int r : reserve)
            students[r-1]++;

        for (int i = 0; i < students.length; i++) {
            if(students[i] == -1) { //일단 -1인 잃어버린 사람을 찾는다
                //양쪽에 있는 사람을 찾아서 넘겨주고, 줬으면 -1 해줘서 0으로 만들어줘서 또 못주게 한다
                if(i-1>=0 && students[i-1] == 1) {
                    students[i]++;
                    students[i-1]--;
                }else if(i+1< students.length && students[i+1] == 1) {
                    students[i]++;
                    students[i+1]--;
                }else   //받을사람이 없을 때 (수업못함)
                    answer--;
            }
        }
        return answer;
    }
}
