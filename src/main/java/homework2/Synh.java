package homework2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Synh {

    private Map<Integer, Integer> hashMap = Collections.synchronizedMap(new HashMap<>());

    private int[] array;

    public Synh(int[] array) {
        this.array = array;
    }

    public void write() {
        synchronized (hashMap) {
            System.err.println(Thread.currentThread().getName());
            for (int i = 0; i < array.length; i++) {
                hashMap.put(i, array[i]);
            }
        }
    }

    public void check() {
        System.err.println(Thread.currentThread().getName());
        for (Map.Entry<Integer, Integer> map : hashMap.entrySet()) {
            System.out.printf("\u001B[34m" + "Ключ-> %s, Значение->%d\n" + "\u001B[0m", map.getKey(), map.getValue());
        }
    }

}
