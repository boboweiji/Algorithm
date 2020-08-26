public class 阿里_比较版本号 {
    public static int Solution(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int i;
        for(i=0;i<s1.length&&i<s2.length;i++){
            if(Integer.parseInt(s1[i])>Integer.parseInt(s2[i])){
                return 1;
            } else if(Integer.parseInt(s1[i])<Integer.parseInt(s2[i])){
                return -1;
            }
        }
        while (i<s1.length){
            if(Integer.parseInt(s1[i])>0){
                return 1;
            }
            i++;
        }
        while(i<s2.length){
            if(Integer.parseInt(s2[i])>0){
                return -1;
            }
            i++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Solution("0.1","1.1"));
        System.out.println(Solution("1.0.1","1"));
        System.out.println(Solution("7.5.2.4","7.5.3"));
    }
}
