package homework1;

import java.util.concurrent.SynchronousQueue;

public class MyRunnable {
    private final int SIZE = 10;
    private SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>(true);

    public void call()  {
        for (int i = 1; i <= SIZE; i++) {
            try {
                System.out.printf("Поступил звонок от: %s №%d\n", Thread.currentThread().getName(),i);
                synchronousQueue.put(i);//stop here
                Thread.sleep(1000);
                System.out.println(synchronousQueue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void answer() {
        while (true) {
            try {
                int x = synchronousQueue.take();
                System.out.printf("Оператор: %s взял звонок -> %d\n", Thread.currentThread().getName(), x);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
