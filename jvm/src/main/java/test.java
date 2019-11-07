import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n,w;
        n = scanner.nextInt();
        w = scanner.nextInt();
        int[] weight = new int[n];
        int[] time = new int[n];
        for(int i=0;i<n;i++){
            weight[i] = scanner.nextInt();
        }
        for(int i=0;i<n;i++){
            time[i] = scanner.nextInt();
        }
        PriorityQueue<P> qu = new PriorityQueue<>();
        long totalWeight = 0;
        int p = 0;
        for (int i = 0; i < n; ++i) {
            if (totalWeight + weight[i] <= w) {
                qu.offer(new P(time[i], i));
                totalWeight += weight[i];
            }
            else {
                p = i;
                break;
            }
        }
        int ans = 0;
        while (!qu.isEmpty()) {
            P u = qu.poll();
            if (qu.isEmpty()) ans = u.x;
            totalWeight -= weight[u.y];
            for (; p < n && totalWeight + weight[p] <= w; ++p) {
                qu.offer(new P(time[p] + u.x, p));
                totalWeight += weight[p];
            }
        }
        System.out.println(ans);
    }

    static class P implements Comparable<P> {
        int x, y;
        P(int a, int b) { x = a; y = b; }

        @Override
        public int compareTo(P o) {
            if (this.x == o.x && this.y == o.y) return 0;
            if (this.x > o.x || this.x == o.x && this.y > o.y) return 1;
            return -1;
        }
    }
}