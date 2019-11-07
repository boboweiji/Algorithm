package graph;

import java.util.*;

// 重新安排行程
public class Solution332 {
    List<String> res = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            if(!adj.containsKey(from)){
                adj.put(from, new PriorityQueue<>());
            }
            adj.get(from).add(to);
        }
        DFS(adj,"JFK");
        return res;
    }

    public void DFS(Map<String, PriorityQueue<String>> adj, String start){
        PriorityQueue<String> pq = adj.get(start);
        while (pq != null && pq.size() != 0){
            String next = pq.poll();
            DFS(adj,next);
        }
        res.add(0,start);
    }
}
