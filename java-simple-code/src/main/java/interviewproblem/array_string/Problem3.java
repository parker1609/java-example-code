package interviewproblem.array_string;

/*
 * URLify: 문자열에 들어 있는 모든 공백을 '%2O'으로 바꾸는 메서드를 작성하라.
 * 최종적으로 모든 문지를 다 담을 수 있을 만큼 충분한 공간이 이미 확보 되어 있으며
 * 문자열의 최종 길이가 함께 주어진다고 가정해도 된다.
 * (자바로 구현한다면 배열안에서 작업할 수 있도록 문자 배열(character array)을 이용하라).
 * 예제
 * 입력 : "Mr John Smith", 13
 * 출력 : "Mr%20John%2OSmith"
 */
public class Problem3 {

    public static String solve(String input) {
        char[] chars = input.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }

    /*
     * char[]를 사용한다면 미리 공백 개수 구해서 그에 따른 전체 크기 구한 후
     * 뒤에서 부터 삽입(새로운 배열을 추가안해도 된다.)
     */

    public static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; ++i) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < str.length) str[trueLength] = '\0';
        for (i = trueLength - 1; i >= 0; --i) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }
}
