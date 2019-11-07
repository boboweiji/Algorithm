package graph;

import java.util.*;

//冗余连接
public class Solution684 {
    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] res = new int[2];
        int[][] adj = new int[n+1][n+1];
        for(int i=0; i<n; i++){
            adj[edges[i][0]][edges[i][1]] = 1;
            adj[edges[i][1]][edges[i][0]] = 1;
        }
        for(int i=n-1; i>=0; i--){
            adj[edges[i][0]][edges[i][1]] = 0;
            adj[edges[i][1]][edges[i][0]] = 0;
            if(BFS(adj,n)){
                res = edges[i];
                break;
            }
            adj[edges[i][0]][edges[i][1]] = 1;
            adj[edges[i][1]][edges[i][0]] = 1;
        }
        return  res;
    }
    public static boolean BFS(int[][] adj,int n){
        int count = n;
        int[] visited = new int[n+1];
        Map<Integer,Integer> pre = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(1);
        visited[1] = 1;
        while (queue.size()!=0){
            int cur = queue.removeFirst();
            count--;
            for(int i=1; i<n+1; i++){
                if(adj[cur][i]==1&&visited[i]==0){
                    queue.addLast(i);
                    pre.put(i,cur);
                    visited[i]=1;
                }else if(adj[cur][i]==1&&visited[i]==1&&pre.get(cur)!=i){
                    return false;
                }
            }
        }
        if(count==0){
            return true;
        }else {
            return false;
        }
    }

    /*  拓扑排序法，比我的好，并查集最好
        public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] inDegrees = new int[n];
        for(int[] edge: edges){
            inDegrees[edge[0]-1]++;
            inDegrees[edge[1]-1]++;
        }
        while (true) {
            //System.out.println(Arrays.toString(inDegrees));
            int flag = -1;
            //System.out.println(flag);
            for (int i = 0; i < n; i++) {
                if (inDegrees[i] == 1) {
                    flag = 1;
                    for (int[] edge : edges) {
                        if (edge[0] == i+1 || edge[1] == i+1) {
                            inDegrees[edge[0] - 1]--;
                            inDegrees[edge[1] - 1]--;
                        }
                    }
                }
            }
            if(flag==-1){
                break;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            if(inDegrees[i]==2){
                list.add(i+1);
            }
        }
        for(int i=edges.length-1;i>=0;i--){
            if(list.contains(edges[i][0])&&list.contains(edges[i][1])){
                return edges[i];
            }
        }
        return new int[2];
    }*/


    public static void main(String[] args) {
        int[][] input = {{1,3},{3,4},{1,5},{3,5},{2,3}};
        System.out.println(findRedundantConnection(input)[0]+","+findRedundantConnection(input)[1]);
    }
}
