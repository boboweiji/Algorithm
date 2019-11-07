package graph;

import java.util.*;

//最小高度树
public class Solution310 {
    /* 递归调用DFS超时
    static int height = 1;
    static int result = 1;
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer> res = new ArrayList<>();
        int[][] adj = new int[n][n];
        for(int i = 0; i < edges.length; i++){
            adj[edges[i][0]][edges[i][1]] = 1;
            adj[edges[i][1]][edges[i][0]] = 1;
        }
        int[] heights = new int[n];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            height = 1;
            result = 1;
            int[] visited = new int[n];
            treeHeight(i,n,adj,visited);
            heights[i] = result;
            if(heights[i]<min){
                min = heights[i];
            }
        }
        for(int i=0; i<n; i++){
            if(heights[i] == min){
                res.add(i);
            }
        }
        return  res;
    }

    public static void treeHeight(int node, int n,int[][] adj, int[] visited){
        visited[node] = 1;
        for(int i = 0; i < n; i++){
            if(adj[node][i] == 1 && visited[i] == 0){
                height++;
                if(height>result)
                    result = height;
                treeHeight(i,n,adj,visited);
                height--;
            }
        }
    }*/

    public static List<Integer> findMinHeightTrees(int n, int[][] edges){
        int[] degree = new int[n];
        boolean[][] adj = new boolean[n][n];   //用int内存会超，用Set比较好
        LinkedList<Integer> queue = new LinkedList<>();
        if(n==1){
            queue.add(0);
            return queue;
        }
        for(int i = 0; i < edges.length; i++){
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
            adj[edges[i][0]][edges[i][1]] = true;
            adj[edges[i][1]][edges[i][0]] = true;
        }
        for(int i=0; i<n; i++){
            if(degree[i] == 1){
                queue.addLast(i);
            }
        }
        while(n>2){
            int size = queue.size();
            n -= size;
            for(int i=0 ; i<size; i++){
                int cur = queue.removeFirst();
                for(int j=0;j<adj[cur].length;j++){
                    if(adj[cur][j]){
                        degree[j]--;
                        if(degree[j]==1){
                            queue.addLast(j);
                        }
                        adj[cur][j]=false;
                        adj[j][cur]=false;
                    }
                }
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        /*int n = 4;
        int[][] edges = {{1,0},{1,2},{1,3}};*/
        System.out.println(findMinHeightTrees(n,edges).toString());
    }
}
