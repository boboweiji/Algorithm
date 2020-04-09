package offer;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 最小的k个数 {
    // 无脑暴力排序
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr,k);
    }

    // 大根堆
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1,v2)->v2-v1);
        for(int i=0;i<arr.length;i++){
            if(pq.size()<k){
                pq.offer(arr[i]);
            } else if(arr[i]<pq.peek()){
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        return pq.stream().mapToInt(Integer::valueOf).toArray();
    }

    // 最佳方法，快排
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return search(arr, 0, arr.length - 1, k - 1);
    }

    private int[] search(int[] arr, int left, int right, int k) {
        int index = getIndex(arr,left,right);
        if(index == k){
            return Arrays.copyOf(arr,k+1);
        }
        return index>k?search(arr,left,index-1,k):search(arr,index+1,right,k);
    }

    private int getIndex(int[] arr, int left, int right) {
        int cur = arr[left];
        int i = left;
        int j = right+1;
        while (true){
            while (++i<right && arr[i]<=cur);
            while (--j>left && arr[j]>=cur);
            if(i>=j) break;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[left] = arr[j];
        arr[j] = cur;
        return j;
    }
}
