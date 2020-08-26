import java.util.*;

public class 美团_小美的跑腿代购 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] ss = line.split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);

        String[] is = new String[n];
        for (int i = 0; i < n; i++) {
            is[i] = in.nextLine();
        }
        List<Integer> list = find(is, m);
        for(int i=0;i<list.size();i++){
            if(i==list.size()-1)
                System.out.println(list.get(i));
            else
                System.out.print(list.get(i)+" ");
        }
    }


    public static List<Integer> find(String[] lines, int m) {
        int len = lines.length;
        List<Integer> res = new ArrayList<>();
        if (len == 0) return res;

        int[][] orders = new int[len][2];
        for (int i = 0; i < len; i++) {
            String line = lines[i];
            String[] ss = line.split(" ");
            orders[i][0] = Integer.parseInt(ss[0]);
            orders[i][1] = Integer.parseInt(ss[1]);
        }

        int[] prices = new int[len];
        for (int i = 0; i < len; i++) {
            prices[i] = orders[i][0] + 2 * orders[i][1];
        }

        boolean[] visited = new boolean[len];
        for (int i = 0; i < m; i++) {
            int maxIndex = findKthElements(prices, visited);
            res.add(maxIndex + 1);
            visited[maxIndex] = true;
        }
        Collections.sort(res);
        return res;
    }

    public static int findKthElements(int[] arr, boolean[] visited) {
        int max = -1;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max && !visited[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}