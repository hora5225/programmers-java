import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334
 * 220815
 */

public class N37_신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        //아래와 같이 HashMap 같은 클래스로 선언하는 것 보다 인터페이스로 선언하는게 더 좋다 왜?
        Map<String, HashSet<String>> reportMap = new HashMap<>();   //유저를 key 에, 유저가 신고한 사람들을 value 에
        Set<String> reportToSet = new HashSet<>(Arrays.asList(report));  //리포트 목록에서 중복을 제거하기위한 set
        Map<String, Integer> reportedCountMap = new HashMap<>();    //신고당한 유저를 key 에, 그 유저가 신고당한 횟수를 value 에

        for (String string : reportToSet) {
            String[] str = string.split(" ");
            String reportUser = str[0];
            String reportedUser = str[1];
            //막혔던 부분. value 에 어떻게 여러 값을 집어넣는지를 몰랐음
            //1번 방법
//            HashSet<String> set = reportMap.get(reportUser);    //value 에 여러 개의 값을 저장해주기 위한 set
//            if (set == null) {  //아직e 해당 반복의 reportUsr 를 key 로 하는 map 이 생성이 안 되었다면
//                set = new HashSet<>();  // 새로 넣어줄 set 생성
//                reportMap.put(reportUser, set);
//            }

            HashSet<String> set = reportMap.computeIfAbsent(reportUser, k1 -> new HashSet<>());
            //아직 해당 반복의 reportUser 를 key 로 하는 map 이 생성이 안 되었다면
            // 새로 넣어줄 set 생성
            set.add(reportedUser);  // 값 추가
            // 맵에 추가

            // 신고당한 횟수를 세서 저장. 윗부분이랑 로직 비슷함
            if (reportedCountMap.containsKey(reportedUser)) {
                int value = reportedCountMap.get(reportedUser);
                reportedCountMap.put(reportedUser, value + 1);
            } else {
                reportedCountMap.put(reportedUser, 1);  //아직 맵에 안드가있으면 key 값 지정해주고 value 1로 설정
            }
        }
        System.out.println(reportMap);
        System.out.println(reportedCountMap);

        for (String key : reportedCountMap.keySet()) {  //키 값 빼내와야해서 keySet 사용
            if (reportedCountMap.get(key) >= k) {   //신고당한 횟수가 k 이상일 때
                for (int i = 0; i < id_list.length; i++) {
                    //id_list 를 돌려서 그 사람이 신고한 사람 중에 key 가 있을 경우 메일받는 횟수 1 추가.
                    //reportMap.get(id_list[i]).contains(key) 가 앞에 오면 null 될 수 있다고 에러 뜨는데, 뒤로가면 괜찮음 왜지?
                    if (reportMap.containsKey(id_list[i]) && reportMap.get(id_list[i]).contains(key)) {
                        answer[i]++;
                    }
                }
            }
        }
        return answer;
    }//end of solution

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        //String[] id_list ={"con", "ryan"};
        //String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        //int k = 3;

        N37_신고결과받기 s37 = new N37_신고결과받기();
        System.out.println(Arrays.toString(s37.solution(id_list, report, k)));
    }
}