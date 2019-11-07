package graph;

public class Solution743 {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] adj = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==j){
                    adj[i][j] = 0;
                    continue;
                }
                adj[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int[] time : times){
            adj[time[0]][time[1]] = time[2];
        }
        int sum = 1;
        int[] visit = new int[N+1];
        int[] dis = new int[N+1];
        visit[K] = 1;
        int cur = K;
        for(int i=1;i<=N;i++){
            dis[i] = adj[K][i];
        }
        for(int i=1; i<=N; i++){
            int min = Integer.MAX_VALUE;
            for(int j=1; j<=N; j++){
                if(visit[j]==0 && dis[j]<min){
                    cur = j;
                    min = dis[j];
                }
            }
            if(min==Integer.MAX_VALUE){
                return -1;
            }
            visit[cur] = 1;
            for(int j=1; j<=N; j++){
                if(visit[j]==0){
                    if(adj[cur][j]!=Integer.MAX_VALUE && dis[j] > dis[cur]+adj[cur][j]){
                        dis[j] = dis[cur]+adj[cur][j];
                    }
                }
            }
        }
        for(int i=1; i<=N; i++){
            if(visit[i]==0){
                return -1;
            }
        }
        return dis[cur];
    }
}
