package graph;

public class Solution765 {
    /*public int minSwapsCouples(int[] row) {
        int len = row.length;
        int res = 0;
        int next = 0;
        for(int i=0; i<len; i+=2){
            if(row[i]%2 == 0){
                next = row[i]+1;
            }else{
                next = row[i]-1;
            }
            if(row[i+1] == next){
                continue;
            } else {
                for(int j = i+2; j<len; j++){
                    if(row[j] == next){
                        row[j] = row[i+1];
                        row[i+1] = next;
                        break;
                    }
                }
                res++;
            }
        }
        return res;
    }*/

    public static int minSwapsCouples(int[] row) {
        int len = row.length;
        int[] location = new int[len];
        for(int i=0; i<len; i++){
            location[row[i]] = i;
        }
        int res = 0;
        int next = 0;
        for(int i=0; i<len; i+=2){
            if(row[i]%2 == 0){
                next = row[i]+1;
            }else{
                next = row[i]-1;
            }
            if(row[i+1] == next){
                continue;
            } else {
                int temp = row[i+1];
                row[location[next]] = row[i+1];
                row[i+1] = next;
                location[temp] = location[next];
                location[next] = i+1;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] row = {0,2,4,6,7,1,3,5};
        System.out.println(minSwapsCouples(row));
    }
}
