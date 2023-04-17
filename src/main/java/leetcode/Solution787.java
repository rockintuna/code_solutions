package leetcode;

import java.util.*;

public class Solution787 {

    private List<List<Node>> graph = new ArrayList<>();

    private Integer[] priceArray;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            int start = flights[i][0];
            int end = flights[i][1];
            int price = flights[i][2];
            graph.get(start).add(new Node(end, price));
        }

        priceArray = new Integer[n];
        Arrays.fill(priceArray, flights.length * 10000);

        dijkstra(src, k);

        return priceArray[dst];
    }

    private void dijkstra(int src, int k) {
        Queue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(src, 0));

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            int num = node.getNum();
            int price = node.getPrice();

            if ( priceArray[num] < price ) {
                continue;
            }

            for (int i = 0; i < graph.get(num).size(); i++) {

                int cost = priceArray[num] + graph.get(num).get(i).getPrice();

                if (cost < priceArray[graph.get(num).get(i).getNum()]) {
                    priceArray[graph.get(num).get(i).getNum()] = cost;
                    priorityQueue.offer(new Node(graph.get(num).get(i).getNum(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution787 solution787 = new Solution787();
        int[][] values = new int[][]{new int[]{1,2,10},
                new int[]{2,0,7},
                new int[]{1,3,8},
                new int[]{4,0,10},
                new int[]{3,4,2},
                new int[]{4,2,10},
                new int[]{0,3,3},
                new int[]{3,1,6},
                new int[]{2,4,5}};
        System.out.println(solution787.findCheapestPrice(5, values, 0,4,1));
    }

    class Node implements Comparable<Node> {

        private int num;
        private int price;

        public int getNum() {
            return num;
        }

        public int getPrice() {
            return price;
        }

        public Node(int num, int price) {
            this.num = num;
            this.price = price;
        }

        @Override
        public int compareTo(Node o) {
            if ( this.price > o.getPrice() ) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}

