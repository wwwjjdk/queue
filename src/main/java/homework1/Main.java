package homework1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

public class Main {
    public static final int COUNT = 3;

    public static void main(String[] args) throws InterruptedException {

     MyRunnable myRunnable = new MyRunnable();
         Thread call = new Thread(null,myRunnable::call, "клиент");

         call.start();
        for(int i =1; i<=COUNT;i++){
            new Thread(null,myRunnable::answer,"оператор "+i).start();
        }

    }
}
