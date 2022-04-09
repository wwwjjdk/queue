package homework2;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyRunnable {
    int[] array;
    private ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();

    public MyRunnable(int[] array) {
        this.array = array;
    }

    public void write() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < array.length; i++) {
            concurrentHashMap.put(i, array[i]);
        }
    }

    public void check() {
        System.out.println(Thread.currentThread().getName());
       /* for (Map.Entry<Integer, Integer> map : concurrentHashMap.entrySet()) {
            System.out.printf("\u001B[34m" + "Ключ-> %s, Значение->%d\n" + "\u001B[0m", map.getKey(), map.getValue());
        }

        */
        Iterator<Integer> iterator = concurrentHashMap.keySet().iterator();
        while (iterator.hasNext()){
           /* try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            */
            Integer i = iterator.next();
            System.out.printf("Ключ-> %s, Значение-> %d\n",i,concurrentHashMap.get(i));
        }
    }
}
