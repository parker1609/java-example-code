package studytest.thread;

public class BThread implements Runnable {

    @Override
    public void run() {
        ThreadLocalVO.set("B thread local value!!");

        System.out.println(ThreadLocalVO.get());
    }
}
