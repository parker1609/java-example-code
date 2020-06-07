package studytest.thread;

public class ThreadLocalVO {
    private static final ThreadLocal<String> tl = new ThreadLocal<>();

    public static void set(String str) {
        tl.set(str);
    }

    public static String get() {
        return tl.get();
    }

    public static void remove() {
        tl.remove();
    }
}
