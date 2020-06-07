package studytest.thread;

public class MainThread {
    public static void main(String[] args) {
        Thread a = new Thread(new AThread());
        Thread b = new Thread(new BThread());

        ThreadLocalVO.set("Main Thread Local Value!!");

        a.start();
        b.start();

        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ThreadLocalVO.get());
        System.out.println("main thread end.");
    }
}
