package offer;

import java.util.ArrayList;
import java.util.List;

public class 顺时针打印矩阵 {
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0)
            return new int[0];
        int xstart = 0, ystart = 0;
        int xend = matrix[0].length-1, yend = matrix.length-1;
        int[] result = new int[matrix.length*matrix[0].length];
        int index = 0;
        while (xstart<=xend&&ystart<=yend){
            for(int i=xstart;i<=xend;i++){
                result[index++]=matrix[ystart][i];
            }
            if(++ystart>yend) break;
            for(int i=ystart;i<=yend;i++){
                result[index++]=matrix[i][xend];
            }
            if(--xend<xstart) break;
            for(int i=xend;i>=xstart;i--){
                result[index++]=matrix[yend][i];
            }
            if(--yend<ystart) break;
            for(int i=yend;i>=ystart;i--){
                result[index++]=matrix[i][xstart];
            }
            if(++xstart>xend) break;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralOrder(matrix);
    }
}
