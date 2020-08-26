import java.util.LinkedList;
import java.util.Scanner;

public class 度小满_滑动窗口 {

    public static void main(String[] args) {
        find(4, 5, 3, 3);

    }


    public static int find (int matrixR, int matrixC, int winR, int winC) {
        int[][] matrix = new int[matrixR][matrixC];
        for (int i = 0; i < matrixR; i++) {
            for (int j = 0; j < matrixC; j++) {
                matrix[i][j] = (i + 1) * (j + 1) % 10;
            }
        }


        int[][] maxWin = new int[matrixR - winR + 1][matrixC - winC + 1];
        int[][] maxs = new int[matrixR][matrixC - winC + 1];
        for (int i = 0; i < matrixR; i++) {
            int[] rows = matrix[i];
            LinkedList<Integer> queue = new LinkedList<>();
            int index = 0;
            for (int j = 0; j < matrixC; j++) {
                if (!queue.isEmpty() && j - queue.peek() >= winC) {
                    queue.poll();
                }
                int n = rows[j];
                while (!queue.isEmpty() && n > rows[queue.peekLast()]) {
                    queue.pollLast();
                }
                queue.offer(j);
                if (j >= winC - 1) {
                    maxs[i][index++] = rows[queue.peek()];
                }
            }
        }

        int count = 0;
        for (int i = 0; i < maxs[0].length; i++) {
            int[] rows = new int[maxs.length];
            for (int j = 0; j < rows.length; j++) {
                rows[j] = maxs[j][i];
            }
            LinkedList<Integer> queue = new LinkedList<>();
            int index = 0;
            for (int j = 0; j < matrixR; j++) {
                if (!queue.isEmpty() && j - queue.peek() >= winR) {
                    queue.poll();
                }
                int n = rows[j];
                while (!queue.isEmpty() && n > rows[queue.peekLast()]) {
                    queue.pollLast();
                }
                queue.offer(j);
                if (j >= winR - 1) {
                    count += rows[queue.peek()];
                }
            }
        }

        return count;
    }

}
