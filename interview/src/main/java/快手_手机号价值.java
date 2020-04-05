import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 快手_手机号价值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(",");
        boolean flag = false;
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        int maxKey = 0;
        for(int i=0; i<s1.length; i++){
            int dp[][] = new int[11][2];
            int bcount = 0;
            int zcount = 0;
            int fcount = 0;
            for(int j=4;j<11;j++){
                if(s1[i].charAt(j) == s1[i].charAt(j-1)+1){
                    if(dp[j-1][0]>=0)
                        dp[j][0] = dp[j-1][0]+1;
                    else
                        dp[j][0] = 1;
                    if(dp[j][0]>zcount){
                        zcount=dp[j][0];
                    }
                } else if(s1[i].charAt(j) == s1[i].charAt(j-1)-1){
                    if(dp[j-1][0]<=0)
                        dp[j][0] = dp[j-1][0]-1;
                    else
                        dp[j][0] = -1;
                    if(-dp[j][0]>fcount){
                        fcount = -dp[j][0];
                    }
                } else if(s1[i].charAt(j) == s1[i].charAt(j-1)){
                    if(dp[j-1][1]>=0)
                        dp[j][1] = dp[j-1][1]+1;
                    if(dp[j][1]>bcount){
                        bcount=dp[j][1];
                    }
                }
            }
            int max1 = Math.max(zcount,fcount);
            if(max1>1)
                flag = true;
            if(bcount>1){
                flag = true;
            }
            int shu = 0;
            if(max1>bcount){
                shu = max1*2;
            } else {
                shu = bcount*2+1;
            }
            if(shu>=4){
                if(maxKey<shu){
                    maxKey = shu;
                }
                if(map.containsKey(shu)){
                    map.get(shu).add(s1[i]);
                } else {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(s1[i]);
                    map.put(shu,list);
                }
            }
        }
        if(!flag){
            System.out.println("null");
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i = maxKey;i>=4;i--){
                if(map.containsKey(i)){
                    for(String ss : map.get(i)){
                        sb.append(ss).append(",");
                    }
                }
            }
            System.out.println(sb.deleteCharAt(sb.length()-1));
        }
    }
}
