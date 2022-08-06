/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12926
 * 220804
 */
public class N30_시저암호 {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char c = 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);    //캐릭터로 변환
            if (c == 32) {  //  0일 때
                sb.append(" ");
            }
            else if (c >= 65 && c <= 90) {  //  대문자일 경우
                if (c + n > 90) {   // 넘어갈 경우
                    sb.append((char) (c + n - 26));
                } else {
                    sb.append((char) (c + n));
                }
            }
            else if (c >= 97 && c <= 122) { //  소문자일 경우
                if (c + n > 122) {
                    sb.append((char) (c + n - 26));
                } else {
                    sb.append((char) (c + n));
                }
            }
        }
        answer = String.valueOf(sb);
        return answer;
    }

    public static void main(String[] args) {
        N30_시저암호 n30 = new N30_시저암호();
        String s = "a B z";
        int n = 4;
        System.out.println(n30.solution(s, n));
    }
}
