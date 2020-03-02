package interviewproblem.array_string;

/*
 * 하나 빼기 : 문자열을 편집하는 방법 에는 세 가지 종류가 있다.
 * 문자 삽입, 문자 삭제, 문자 교체. 문자열 두 개가 주어졌을때,
 * 문자열을 같게 만들기 위한 편집 횟수가 1회 이내인지 확인하는 함수를 작성하라.
 * 예제
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
public class Problem5 {

    /*
     * 두 문자열 중 길이가 긴 문자열을 선택한다.
     * 긴 문자열 기준으로 편집은 문자 삭제, 문자 교체 2가지만 검사하면 된다.
     * (문자 삽입이 문자 삭제보다 복잡한 로직이라고 생각했다.)
     */
    public static boolean solve(String input1, String input2) {
        if (input1.equals(input2)) {
            return true;
        }
        if (Math.abs(input1.length() - input2.length()) > 1) {
            return false;
        }

        String longer = input1.length() > input2.length() ? input1 : input2;
        String shorter = input1.length() > input2.length() ? input2 : input1;

        if (longer.length() == shorter.length()) {
            char[] str1 = longer.toCharArray();
            char[] str2 = shorter.toCharArray();
            for (int i = 0; i < longer.length(); ++i) {
                for (int j = 0; j < 128; ++j) {
                    str1[i] = (char) j;
                    if (isEquals(str1, str2)) {
                        return true;
                    }
                }
            }
        } else {
            char[] str2 = shorter.toCharArray();
            for (int i = 0; i < longer.length(); ++i) {
                char[] str1 = longer.toCharArray();
                for (int j = i + 1; j < longer.length(); ++j) {
                    str1[j - 1] = str1[j];
                }
                str1[longer.length() - 2] = '\0';
                if (isEquals(str1, str2)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isEquals(char[] str1, char[] str2) {
        for (int i = 0; i < str1.length; ++i) {
            if (str1[i] != str2[i]) {
                return false;
            }
        }
        return true;
    }

    /*
     *
     */

    public static boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }

        return false;
    }

    private static boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    /* s1에 문자 하나를 삽입해서 s2를 만들 수 있는지 확인
     * s1, s2 중 길이가 짧은 문자열이 s1이어야 한다.   */
    private static boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s1.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}
