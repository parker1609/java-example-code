package studytest.thread;

public class NormalLocalVO {
    private static String value;

    public static void set(String str) {
        value = str;
    }

    public static String get() {
        return value;
    }

    public static void remove() {
        value = "";
    }
}
