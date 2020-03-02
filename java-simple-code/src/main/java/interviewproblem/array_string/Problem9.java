package interviewproblem.array_string;

/*
 * 문자열 회전: 한 단어가 다른 문자열에 포함되어 있는지 판별하는 isSubstring 이라는 메서드가 있다고 하자.
 * sl과 s2의 두 문자열이 주어졌고, s2가 sl을 회전시킨 결과인지 판별하고자 한다.
 * (가령 ‘waterbottle’은 ‘erbottlewat’을 회전시켜 얻을 수 있는 문자열이다.)
 * isSubstring 메서드를 한 번만 호출해서 판변할 수 있는 코드를 작성하라.
 */
public class Problem9 {

    boolean isRotation(String s1, String s2) {
        int len = s1.length();
        /* s1과 s2의 길이가 같고 빈 문자열이 아닌지 확인 */
        if (len == s2.length() && len > 0) {
            /* s1과 s1을 합친 결과를 새로운 버퍼에 저장 */
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }

        return false;
    }

    /*
     * 구현되어 있다고 가정함
     */
    private boolean isSubstring(String s1s1, String s2) {
        return false;
    }
}
