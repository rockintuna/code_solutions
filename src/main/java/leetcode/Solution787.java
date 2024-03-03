package leetcode;

import java.util.*;

public class Solution787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new LinkedList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new LinkedList<>();
        }
        for(int[] flight: flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph[from].add(new int[]{to, price});
        }
        k++;
        return dijkstra(graph, src, dst, k);
    }
    class State{
        int id;
        int costFromSrc;
        int nodeNumFromSrc;
        public State(int id, int costFromSrc, int nodeNumFromSrc){
            this.id = id;
            this.costFromSrc = costFromSrc;
            this.nodeNumFromSrc = nodeNumFromSrc;
        }
    }
    public int dijkstra(List<int[]>[] graph, int src, int dst, int k){
        int[] costTo = new int[graph.length];
        int[] nodeNumTo = new int[graph.length];
        Arrays.fill(costTo, Integer.MAX_VALUE);
        Arrays.fill(nodeNumTo, Integer.MAX_VALUE);
        costTo[src] = 0;
        nodeNumTo[src] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.costFromSrc - b.costFromSrc;
        });
        pq.offer(new State(src, 0, 0));
        while(!pq.isEmpty()){
            State curState = pq.poll();
            int curId = curState.id;
            int curCostFromSrc = curState.costFromSrc;
            int curNodeNumFromSrc = curState.nodeNumFromSrc;
            if(curId == dst) return curCostFromSrc;
            if(curNodeNumFromSrc == k) continue;
            for(int[] neighbors: graph[curId]){
                int nextId = neighbors[0];
                int nextPrice = curCostFromSrc + neighbors[1];
                int nextNodeNumFromSrc = curNodeNumFromSrc + 1;
                if(costTo[nextId] > nextPrice || nodeNumTo[nextId] > nextNodeNumFromSrc){
                    pq.offer(new State(nextId, nextPrice, nextNodeNumFromSrc));
                }
                if(costTo[nextId] > nextPrice){
                    costTo[nextId] = nextPrice;
                    nodeNumTo[nextId] = nextNodeNumFromSrc;
                }
            }
        }
        return -1;
    }
}

