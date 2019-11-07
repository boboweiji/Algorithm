package string;


public class Solution44 {
    // 递归超时
    public static boolean isMatchDG(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        if (s.isEmpty()) {
            if(p.charAt(0) != '*')
                return false;
            else
                return isMatchDG(s, p.substring(1));
        }
        if(!s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '?'))
            return isMatchDG(s.substring(1), p.substring(1));

        else if (p.charAt(0) == '*'){
            int count = 0;
            for(int i=1;i<p.length();i++){
                if(p.charAt(i) == '*')
                    count++;
                else
                    break;
            }
            p = p.substring(count);
            return (isMatchDG(s, p.substring(1)) ||
                    (isMatchDG(s.substring(1), p)));
        }
        return false;
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0; i--){
            for (int j = p.length() - 1; j >= 0; j--){
                boolean first_match = (i < s.length() &&
                        (p.charAt(j) == s.charAt(i) ||
                                p.charAt(j) == '?' || p.charAt(j) == '*'));
                if (j < p.length() && p.charAt(j) == '*'){
                    dp[i][j] = dp[i][j+1] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String s = "ab";
        String p = "?*";
        System.out.println(isMatch(s,p));
    }
}
