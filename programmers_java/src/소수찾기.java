import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12921
 * 2220802
 */
public class 소수찾기 {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n]; //기본으로 모든 값이 0으로 초기화됨
        for (int i = 1; i < n; i++) {
            if (arr[i] == 0) {
                if(i<(int)Math.sqrt(n)) {   //에라토스테네스의 체
                    for (int j = i; j < n; ) {
                        arr[j] = 1; //소수가 아니라고 체킹
                        j = j + (i + 1);    //모든 배수를 1로 바꿔주자
                    }
                }
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        소수찾기 s = new 소수찾기();
        System.out.println(s.solution(10));
    }
}
