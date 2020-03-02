package interviewproblem.array_string;

/*
 * 문자열 압축: 반복되는 문자의 개수를 세는 방식의 기본적인 문자열 압축 메서드를 작성하라.
 * 예를 들어 문자열 aabccccaaa를 압축하면 a2blc5a3이 된다. 만약 '압축된' 문자열의 길이가
 * 기존 문자열의 길이보다 길다면 기존 문자열을 반환해야 한다.
 * 문자열은 대소문자 알파벳(a~z)으로만 이루어져 있다.
 */
public class Problem6 {

    /*
     * 문자열을 추가하는데 효율적인 StringBuilder를 사용한다.
     */
    public static String solve(String input) {
        StringBuilder compressed = new StringBuilder();

        for (int i = 0; i < input.length(); ++i) {
            int freq = 1;
            for (int j = i + 1; j < input.length(); ++j) {
                if (input.charAt(i) == input.charAt(j)) {
                    freq++;
                } else {
                    i = j - 1;
                    break;
                }
            }
            compressed.append(input.charAt(i));
            compressed.append(freq);
        }

        return compressed.toString().length() > input.length() ? input : compressed.toString();
    }
}
