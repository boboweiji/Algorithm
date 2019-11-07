package graph;


import java.util.ArrayList;
import java.util.LinkedList;

//课程表II
public class Solution210 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int copy = numCourses;
        int[] courses = new int[numCourses];
        ArrayList<Integer> res = new ArrayList<>();
        for(int[] prerequisite : prerequisites){
            courses[prerequisite[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(courses[i] == 0){
                queue.add(i);
                res.add(i);
            }
        }
        while(queue.size()!=0){
            Integer no = queue.remove(0);
            numCourses--;
            for(int[] prerequisite : prerequisites){
                if(prerequisite[1] == no){
                    courses[prerequisite[0]]--;
                    if(courses[prerequisite[0]]==0){
                        queue.add(prerequisite[0]);
                        res.add(prerequisite[0]);
                    }
                }
            }
        }
        if( numCourses != 0 ){
            return new int[copy];
        }else{
            int[] result = new int[copy];
            for(int i=0;i<copy;i++){
                result[i] = res.get(i);
            }
            return result;
        }
    }
}
