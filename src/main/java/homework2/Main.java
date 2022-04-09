package homework2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static final int SIZE = 1000;

    public static void main(String[] args) {
        //Synh synh = new Synh(createArray());
        MyRunnable myRunnable = new MyRunnable(createArray());
        new Thread(null, myRunnable::write, "write").start();
        new Thread(null, myRunnable::check, "check").start();

        //new Thread(null,synh::write,"writeWithoutCurrent").start();
       // new Thread(null,synh::check,"checkWithoutCurrent").start();


    }

    public static int[] createArray() {
        int[] array = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = (int) Math.floor(Math.random() * SIZE);
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}
