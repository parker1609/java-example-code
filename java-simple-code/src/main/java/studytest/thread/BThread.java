package studytest.thread;

public class BThread implements Runnable {

    @Override
    public void run() {
        ThreadLocalVO.set("B thread local value!!");
        NormalLocalVO.set("B Thread Normal Value!!");

        System.out.println(ThreadLocalVO.get());
        System.out.println(NormalLocalVO.get());
    }
}
