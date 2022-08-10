import java.util.HashSet;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 * 220809
 */
public class N32_폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);   //해시셋에 저장. 이러면 중복된 요소들이(중복된 포켓몬) 한 번만 저장되게 된다
        }
        //중복을 뺀 nums 의 요소의 개수(폰켓몬 종류)와, 총 선택할 수 있는 n/2 를 비교한다
        if (set.size() >= nums.length / 2) {
            answer = nums.length / 2;   //포켓몬 갯수가 n/2 보다 많으면 n/2만큼만 가져갈 수 있다.
        } else {
            answer = set.size();    //그게 아니면 한종류씩 다 델구갈수있다
        }

        //삼항 연산자 사용하자
        //return (nums.length / 2 > a.size()) ? a.size() : nums.length / 2;
        return answer;
    }//end of solution

    public static void main(String[] args) {
        N32_폰켓몬 s32 = new N32_폰켓몬();
        int[] nums = {3, 1, 2, 3};
        System.out.println(s32.solution(nums));
    }
}
