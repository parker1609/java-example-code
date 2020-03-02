package interviewproblem.array_string;

/*
 * 순열확인: 문자열 두 개가 주어졌을 때 이 둘이 서로 순열 관계에 있는 지 확인하는 메서드를 작성하라.
 */
public class Problem2 {
    /*
     * 아스키 코드만을 포함한다고 하는 조건이 있다면 두 문자열의 빈도수 개산하여 같은지 확인할 수 있다.
     * O(N)
     */
    public static boolean solve(String input1, String input2) {
        if (input1.length() != input2.length()) {
            return false;
        }

        int len = input1.length();
        int[] freq1 = new int[128];
        int[] freq2 = new int[128];

        for (int i = 0; i < len; ++i) {
            freq1[input1.charAt(i)]++;
            freq2[input2.charAt(i)]++;
        }

        for (int i = 0; i < 128; ++i) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    /*
     * 아스키 코드가 아니면 맵을 활용할 수 있다.
     * 두 문자열을 정렬해서 순서대로 비교해도 된다.
     */
}
