package interviewproblem.array_string;

import java.util.HashMap;

/*
 * 중복이 없는가: 문자열이 주어졌을 때, 이 문자열에 같은 문자가 중복되어 등장하는지
 * 확인하는 알고리즘을 작성하라.
 * 자료구조를 추가로 사용하지 않고 풀 수 있는 알고리즘 또한 고민하라
 */
public class Problem1 {

    /*
     * 입력되는 문자열이 아스키코드 값만을 포함하고 있다면 128 개의 int 배열로 해결할 수 있다.
     * (맵 사용안해도 됨)
     * 시간 복잡도는 O(N)
     */
    public static boolean solve(String input) {
        HashMap<Character, Integer> frequency = new HashMap<>();

        for (int i = 0; i < input.length(); ++i) {
            char currentChar = input.charAt(i);
            if (frequency.containsKey(currentChar)) {
                return false;
            } else {
                frequency.put(currentChar, 1);
            }
        }

        return true;
    }

    /*
     * 시간 복잡도는 O(N^2)
     */
    public static boolean solveWithoutDataStructure(String input) {
        int len = input.length();
        for (int i = 0; i < len - 1; ++i) {
            for (int j = i + 1; j < len; ++j) {
                if (input.charAt(i) == input.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    /*
     * 입력된 문자열을 정렬할 수 있다면 정렬해서 비교하면 O(NlogN)으로 가능
     */
}
