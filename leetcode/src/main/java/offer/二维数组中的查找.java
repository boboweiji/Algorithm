package offer;

public class 二维数组中的查找 {
    // 暴力
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        boolean flag = false;
        for(int i = 0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length;j++){
                if(target == matrix[i][j]){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    // 减行减列
    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if(matrix==null || matrix.length ==0 || matrix[0].length ==0)
            return false;
        boolean flag = false;
        int i=0;
        int j=matrix[0].length-1;
        while(i<matrix.length && j>=0){
            if(target == matrix[i][j]){
                flag = true;
                break;
            } else if(target > matrix[i][j]){
                i++;
            } else {
                j--;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        //int[][] input = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] input = {};
        System.out.println(findNumberIn2DArray2(input,5));
    }
}
