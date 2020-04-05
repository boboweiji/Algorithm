package offer;

public class 字符流中第一个不重复的字符 {

    private int[] occurence = new int[256];
    private int index = 1;

    //Insert one char from stringstream
    void Insert(char ch)
    {
        if(occurence[ch] == 0)
            occurence[ch] = index;
        else if(occurence[ch] > 0)
            occurence[ch] = -1;

        index++;
    }
    //return the first appearence once char in current stringstream
    char FirstAppearingOnce()
    {
        char ch = '#';
        int minIndex = index;
        for(int i=0;i<256;i++){
            if(occurence[i] > 0 && occurence[i]<minIndex){
                ch = (char)i;
                minIndex = occurence[i];
            }
        }
        return ch;
    }
}
