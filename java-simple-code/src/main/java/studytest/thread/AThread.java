package studytest.thread;

public class AThread implements Runnable {

    @Override
    public void run() {
        ThreadLocalVO.set("A thread local value!!");
        NormalLocalVO.set("A Thread Normal Value!!");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ThreadLocalVO.get());
        System.out.println(NormalLocalVO.get());
    }
}
