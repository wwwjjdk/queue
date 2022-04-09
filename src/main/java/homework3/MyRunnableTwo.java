package homework3;

import java.util.concurrent.PriorityBlockingQueue;

public class MyRunnableTwo {
    private final int SIZE = 60;
    public static final String RESET = "\u001B[0m";
    private PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue();
    public static final String ANSI_BLUE = "\u001B[34m";

    public void call() {
        for (int i = 1; i <= SIZE; i++) {
            priorityBlockingQueue.offer(i);
            System.out.printf("Добавлен %s -> №%d\n", Thread.currentThread().getName(), i);//err red
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void answer() {
        while (!priorityBlockingQueue.isEmpty()) {
            try {
                int x = priorityBlockingQueue.take();
                System.out.printf(ANSI_BLUE + "%s взял абонента %d\n" + RESET, Thread.currentThread().getName(), x);
                System.out.println(priorityBlockingQueue);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}