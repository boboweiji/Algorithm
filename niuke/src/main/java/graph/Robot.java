package graph;

import java.util.*;

//机器人走方格II
public class Robot {
    public static int countWays(int[][] map, int x, int y) {
        // write code here
        //return Ways(map,0,0,x,y);
        int [][] count = new int[x][y];
        for(int i = x-1 ; i >= 0; i--){
            for(int j = y-1; j >= 0; j--){
                count[i][j] = 1;
                if(map[i][j] != 1){
                    count[i][j] = 0;
                }else if(i == x-1 && j < y-1) {
                    count[i][j] = count[i][j+1];
                }else if(i < x-1 && j == y-1){
                    count[i][j] = count[i+1][j];
                }else if(i < x-1 && j < y-1){
                    count[i][j] = (count[i][j+1]+count[i+1][j])%1000000007;
                }
            }
        }
        return count[0][0];
    }

    //递归（超时，过不了）
    public static int Ways(int[][] map, int startx, int starty, int x, int y) {
        // write code here
        if(startx == x-1 && starty == y-1){
            return 0;
        }else if(startx == x-1){
            int a = 1;
            for(int i=starty+1; i<y;i++){
                if(map[startx][i] != 1){
                    a = 0;
                    break;
                }
            }
            return a;
        }else if(starty == y-1) {
            int a = 1;
            for(int i=startx+1; i<x;i++){
                if(map[i][starty] != 1){
                    a = 0;
                    break;
                }
            }
            return a;
        }else {
            int a,b;
            a=map[startx][starty+1] != 1? 0 : Ways(map,startx,starty+1,x,y)%1000000007;
            b=map[startx+1][starty] != 1? 0 : Ways(map,startx+1,starty,x,y)%1000000007;
            return (a+b)%1000000007;
        }
    }

    public static void main(String[] args) {
        int[][] map = {{1,1,1},{1,1,1},{1,1,1}};
        int x = 3;
        int y = 3;
        System.out.println(countWays(map,x,y));
    }
}
