package designpattern;

public class SingleTonePattern {
    public static void main(String[] args) {
        WaitingQueue queue = WaitingQueue.getInstance();
        WaitingQueue queue1 = WaitingQueue.getInstance();

        System.out.println(queue1 == queue);
    }
}
