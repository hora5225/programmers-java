import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


//class Solution {
//    public String[] solution(String[] strings, int n) {
//        Arrays.sort(strings, new Comparator<String>() {
//
//            @Override
//            public int compare(String s1, String s2){
//                if(s1.charAt(n) > s2.charAt(n)) return 1;
//                else if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
//                else if(s1.charAt(n) < s2.charAt(n)) return -1;
//                else return 0;
//            }
//
//        });
//        return strings;
//        }
//    }


class N26문자열내마음대로정렬하기 {
    public String[] solution(String[] strings, int n){
        String[] answer = new String[strings.length];

        ArrayList<String> stringArr = new ArrayList<>();

        for(String string : strings) {
            stringArr.add(string.charAt(n) + string);
        }
        //[usun, ebed, acar] 이 됨

        Collections.sort(stringArr);
        //[acar, ebed, usun]이 됨

        for (int i = 0; i < stringArr.size(); i++) {
            //i번째 리스트를 get 한 다음 인덱스 1부터 끝까지를 answer[i]에 넣어줌
            answer[i] = stringArr.get(i).substring(1);
        }
        return answer;
    }

    public static void main(String[] args) {
        N26문자열내마음대로정렬하기 s = new N26문자열내마음대로정렬하기();
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        System.out.println(Arrays.toString(s.solution(strings, n)));
    }
}


/*
class 문자열내마음대로정렬하기 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        System.out.println(Arrays.toString(s.solution(strings, n)));
    }
}

class Solution {
    public String[] solution(String[] strings, int n){
        String[] answer = new String[strings.length];

        ArrayList<String> stringArr = new ArrayList<>();

        for(String string : strings) {
            stringArr.add(string.charAt(n) + string);
        }
        //[usun, ebed, acar] 이 됨

        Collections.sort(stringArr);
        //[acar, ebed, usun]이 됨

        for (int i = 0; i < stringArr.size(); i++) {
            //i번째 리스트를 get 한 다음 인덱스 1부터 끝까지를 answer[i]에 넣어줌
            answer[i] = stringArr.get(i).substring(1);
        }
        return answer;
    }
}
*/



