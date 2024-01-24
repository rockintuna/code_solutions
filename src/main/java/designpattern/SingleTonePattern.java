package designpattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingleTonePattern {
    public static void main(String[] args) {
        WaitingQueue queue = WaitingQueue.getInstance();
        try {
            Constructor<WaitingQueue> declaredConstructor = WaitingQueue.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            WaitingQueue queue1 = declaredConstructor.newInstance();
            System.out.println(queue1 == queue);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        Runtime runtime1 = Runtime.getRuntime();
        Runtime runtime2 = Runtime.getRuntime();
        System.out.println(runtime2 == runtime1);
    }
}
