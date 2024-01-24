package designpattern;

import java.util.PriorityQueue;
import java.util.Queue;

public enum WaitingQueueEnum {
    INSTANCE();

    private final Queue<String> queue = new PriorityQueue<>();

    public Queue<String> getQueue() {
        return queue;
    }
}
