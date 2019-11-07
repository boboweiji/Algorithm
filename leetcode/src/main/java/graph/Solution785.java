package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//判断二分图
public class Solution785 {
    /*  自己的蠢逼方法，能过，时间击败9%，属实fw
        public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int[] visit = new int[n];
        set1.add(0);
        visit[0] = 1;
        queue.addLast(0);
        int num = 0;
        while (!queue.isEmpty()){
            int cur = queue.removeFirst();
            num++;
            int[] nexts = graph[cur];
            Set<Integer> curSet = null;
            Set<Integer> anotherSet = null;
            if(set1.contains(cur)){
                curSet = set1;
                anotherSet = set2;
            }else{
                curSet = set2;
                anotherSet = set1;
            }
            for(int i : nexts){
                if(visit[i]==0){
                    queue.addLast(i);
                    visit[i] = 1;
                }
                if(curSet.contains(i)){
                    return false;
                }else if(!anotherSet.contains(i)){
                    anotherSet.add(i);
                }
            }
            if(queue.isEmpty()&&num!=n){
                for(int i=0; i<n; i++){
                    if(visit[i] == 0){
                        queue.addLast(i);
                        visit[i]=1;
                        break;
                    }
                }
            }
        }
        return true;
    }*/

    int V = 100;
    boolean[]color = new boolean[V];
    boolean[]marked = new boolean[V];
    boolean isBipartite = true;
    public boolean isBipartite(int[][] graph) {
        for(int i = 0; i < graph.length; i++){
            if(!isBipartite){//已知非二分图，提前结束
                break;
            }
            if(!marked[i]){
                dfs(graph,i);
            }
        }
        return isBipartite;
    }
    private void dfs(int[][]graph,int i){
        if(!isBipartite){//已知非二分图，提前结束
            return;
        }
        marked[i] = true;
        for(int neighbor : graph[i]){
            if(!marked[neighbor]){
                color[neighbor] = !color[i];
                dfs(graph,neighbor);
            }else if(color[neighbor] == color[i]){
                isBipartite = false;
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{2,4},{2,3,4},{0,1},{1},{0,1},{7},{9},{5},{},{6},{12,14},{},{10},{},{10},{19},{18},{},{16},{15},{23},{23},{},{20,21},{},{},{27},{26},{},{},{34},{33,34},{},{31},{30,31},{38,39},{37,38,39},{36},{35,36},{35,36},{43},{},{},{40},{},{49},{47,48,49},{46,48,49},{46,47,49},{45,46,47,48}};
        //System.out.println(isBipartite(graph));
    }
}
