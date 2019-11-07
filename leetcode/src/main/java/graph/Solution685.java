package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//冗余连接II
public class Solution685 {

        /* 暴力BFS，可过
        public static int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] in = new int[n+1];
        int[] res = new int[2];
        int[][] adj = new int[n+1][n+1];
        int must = 0;
        for(int i=0; i<n; i++){
            adj[edges[i][0]][edges[i][1]] = 1;
            in[edges[i][1]]++;
            if(in[edges[i][1]]>1){
                must = edges[i][1];
            }
        }
        int metaroot = 0;
        for(int j=1;j<n+1;j++){
            if(in[j] == 0){
                metaroot = j;
                break;
            }
        }
        for(int i=n-1; i>=0; i--){
            if(must!=0 && edges[i][1]!=must){
                continue;
            }
            adj[edges[i][0]][edges[i][1]] = 0;
            int root = metaroot;
            if(--in[edges[i][1]] == 0)
                root = edges[i][1];
            if(BFS(adj,root,n)){
                res = edges[i];
                break;
            }
            adj[edges[i][0]][edges[i][1]] = 1;
            in[edges[i][1]]++;
        }
        return  res;
    }

    public static boolean BFS(int[][] adj,int root,int n){
        int count = n;
        int[] visited = new int[n+1];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(root);
        visited[root] = 1;
        while (queue.size()!=0){
            int cur = queue.removeFirst();
            count--;
            for(int i=1; i<n+1; i++){
                if(adj[cur][i]==1&&visited[i]==0){
                    queue.addLast(i);
                    visited[i]=1;
                }else if(adj[cur][i]==1&&visited[i]==1){
                    return false;
                }
            }
        }
        if(count==0){
            return true;
        }else {
            return false;
        }
    }*/

    /*public static int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] in = new int[n+1];
        int[] out = new int[n+1];
        int[] res = new int[2];
        int must = 0;
        for(int i=0; i<n; i++){
            out[edges[i][0]]++;
            in[edges[i][1]]++;
            if(in[edges[i][1]]>1){
                must = edges[i][1];
            }
        }
        for(int i=n-1; i>=0; i--){
            if(must!=0 && edges[i][1]!=must){
                continue;
            }else{
                out[edges[i][0]]--;
                in[edges[i][1]]--;
                if(judge(in,out,n)){
                    res = edges[i];
                    break;
                }
                out[edges[i][0]]++;
                in[edges[i][1]]++;
            }
        }
        return res;
    }

    public static boolean judge(int[] in,int[] out,int n){
        int zero = 0;
        for(int i=1;i<n+1;i++){
            if(in[i]==0){
                zero++;
                if(zero>1 || out[i]==0){
                    return false;
                }
            }else if(in[i]!=1){
                return false;
            }
        }
        if(zero!=1){
            return false;
        }
        return true;
    }*/

    static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return false;
            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else {
                parent[pb] = pa;
                if (rank[pa] == rank[pb]) {
                    rank[pa]++;
                }
            }
            return true;
        }

        int find(int a) {
            while (a != parent[a]) {
                parent[a] = parent[parent[a]];
                a = parent[a];
            }
            return a;
        }
    }

    private final int MAX_EDGE_NUM = 1000;

    public static int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return null;
        }
        int[] c1 = new int[2];
        int[] c2 = new int[2];

        int[] parent = new int[edges.length + 1];
        for (int[] edge : edges) {
            if (parent[edge[1]] != 0) {
                c1 = new int[]{parent[edge[1]], edge[1]};
                c2 = new int[]{edge[0], edge[1]};
                break;
            }
            parent[edge[1]] = edge[0];
        }
        UnionFind uf = new UnionFind(edges.length + 1);
        for (int[] e : edges) {
            if ((e[0] == c1[0] && e[1] == c1[1]) || (e[0] == c2[0] && e[1] == c2[1])) {
                continue;
            }
            if (!uf.union(e[0], e[1])) {
                return e;
            }
        }
        if (!uf.union(c1[0], c1[1])) {
            return c1;
        }
        return c2;
    }

    public static void main(String[] args) {
        int[][] input = {{2,1},{3,1},{4,2},{1,4}};
        System.out.println(findRedundantDirectedConnection(input)[0]+","+findRedundantDirectedConnection(input)[1]);
    }
}
