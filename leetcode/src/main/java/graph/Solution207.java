package graph;

import java.util.LinkedList;

//课程表
public class Solution207 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] courses = new int[numCourses];
        for(int[] prerequisite : prerequisites){
            courses[prerequisite[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(courses[i] == 0){
                queue.add(i);
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
                    }
                }
            }
        }
        return numCourses==0;
    }

    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = {{1,0},{2,1}};
        System.out.println(canFinish(numCourses,prerequisites));
    }
}
