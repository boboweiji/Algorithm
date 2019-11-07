package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 找到最终的安全状态
public class Solution802 {
    /* 傻逼方法超时
    static List<Integer> res = new ArrayList<>();
    static Set<Integer> unsafe = new HashSet<>();
    static boolean flag = true;
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        for(int i=0; i<n; i++){
            flag = true;
            int[] visit = new int[n];
            DFS(graph,visit,i);
            if(flag){
                res.add(i);
            }else {
                continue;
            }
        }
        return res;
    }
    public static void DFS(int[][] graph, int[] visit, int node){
        if(!flag || res.contains(node)){
            return;
        } else if(visit[node]==1 || unsafe.contains(node)){
            for(int i=0; i<visit.length; i++){
                if(!unsafe.contains(node)){
                    unsafe.add(node);
                }
            }
            flag = false;
            return;
        } else {
            visit[node] = 1;
            int[] neibors = graph[node];
            for(int neibor : neibors){
                DFS(graph,visit,neibor);
            }
            visit[node] = 0;
        }
    }*/

    /*
     * 0：未访问
     * 1：以访问
     * 2：安全
     * 3：成环
     */
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<Integer>();//记录结果
        int n = graph.length;//长度
        int[] type = new int[n];//访问类型
        for ( int i = 0; i < n; i++ ) {
            if ( DFS(graph, i, type) == 2 ) ans.add(i);
        }
        return ans;
    }

    public static int DFS( int[][] graph, int index, int[] type ) {
        if ( type[index] == 1 ) return 3;//如果访问过了，说明成环
        if ( type[index] != 0 ) return type[index];	//如果不是0，返回自身
        type[index] = 1;//标记访问了
        for (int i : graph[index]) {
            if ( DFS(graph, i, type) == 3 ) {
                type[i] = 3;
                return 3;
            }
        }

        type[index] = 2;//不成环
        return 2;
    }

    public static void main(String[] args) {
        //int[][] graph = {{},{0,2,3,4},{3},{4},{}};
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> list = eventualSafeNodes(graph);
        for(int i : list){
            System.out.println(i);
        }
    }
}
