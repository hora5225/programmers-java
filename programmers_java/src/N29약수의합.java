import java.util.ArrayList;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12928
 * 220802
 */
public class N29약수의합 {
    public int solution(int n) {
        int answer = 0;
        if(n==1){   //1일때는 그냥 리턴
            return 1;
        }
        int sqrt = (int)Math.sqrt(n);


        ArrayList<Integer> arr = new ArrayList<>(); //생각해보니 그냥 answer 에 더하면됨
        int j = 0;
        for (int i = 1; i <= sqrt; i++) { //반만 돌려도 됨
            if(n%i==0) {//i가 약수일 때만 실행
                if(arr.contains(i)){    //이미 있으면 돌릴만큼 돌린거니까 for 문 빠져나온다
                    break;
                }
                arr.add(i);
                if(i!=(n/i)){arr.add(n/i); // [1, 3, 9] 처럼  약수의 제곱이 n일 경우
                }
                System.out.println(arr);
                answer = arr.stream().mapToInt(Integer::intValue).sum();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        N29약수의합 s = new N29약수의합();
        int n = 12;
        System.out.println(s.solution(n));
    }
}
