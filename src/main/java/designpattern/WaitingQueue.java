package designpattern;

import java.util.PriorityQueue;
import java.util.Queue;

public class WaitingQueue {
    private Queue<String> queue = new PriorityQueue<>();

    private static class WaitingQueueHolder {
        private static final WaitingQueue INSTANCE = new WaitingQueue();
    }

    public static WaitingQueue getInstance() {
        return WaitingQueueHolder.INSTANCE;
    }

    private WaitingQueue() {

    }
}
