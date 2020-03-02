package interviewproblem.array_string;

/*
 * 회문 순열: 주어진 문자열이 회문(palindrome)의 순열인지 아닌지 확인하는 함수를
 * 작성하라. 회문이란 앞으로 읽으나 뒤로 읽으나 같은 단어 혹은 구절을 의미하며,
 * 순열이란 문자열을 재배치하는 것을 뜻한다. 회문이 꼭 사전에 등장하는 단어로 제한될 필요는 없다.
 * 예제
 * 입력: tact coa
 * 출력: True (순열: "taco cat", "atco cta" 등등)
 */
public class Problem4 {

    /*
     * 아스키 코드 값만을 취급한다.
     * 짝수인 문자는 제한없이 있어도 된다.
     * 홀수인 문자가 1개이거나 없어야 한다.
     * 공백은 무시한다.
     */
    public static boolean solve(String input) {
        int[] frequency = new int[128];

        for (int i = 0; i < input.length(); ++i) {
            char currentChar = input.charAt(i);
            if (currentChar != ' ') {
                frequency[currentChar]++;
            }
        }

        int numOfOdd = 0;
        for (int i = 0; i < 128; ++i) {
            if (frequency[i] % 2 != 0) {
                numOfOdd++;
            }
        }

        return numOfOdd == 0 || numOfOdd == 1;
    }

    /*
     * 메서드 하나마다 하나의 책임으로 분리해보자.
     */
    public static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    /* 홀수 문자가 한 개 이상 존재하는지 확인한다. */
    private static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    /* 각 문자에 숫자를 대응시킨다. a->0, b->1, c->2 등등
     * 대소문자 구분이 없고, 문자가 아닌 경우에는 -1로 대응시킨다. */
    private static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }

        return -1;
    }

    /* 각 문자가 몇 번 등장했는지 센다. */
    private static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z')
                - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }
}
