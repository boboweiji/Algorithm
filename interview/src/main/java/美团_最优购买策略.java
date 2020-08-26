import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 美团_最优购买策略 {
    public static void main(String[] args) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int sum = 0;
        for(int i = 0; i<n; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            sum += a;
            if(b==1)
                listA.add(a);
            else
                listB.add(a);
        }
        listA.sort(Comparator.reverseOrder());
        listB.sort(Comparator.reverseOrder());
        int indexA = 0;
        int indexK = 0;
        int zhekou = 0;
        while (indexA<listA.size()&&indexK<k-1){
            zhekou += listA.get(indexA);
            indexA++;
            indexK++;
        }
        if(indexA<listA.size()){
            if(listB.size()!=0)
                zhekou += Math.min(listA.get(listA.size()-1),listB.get(listB.size()-1));
            else
                zhekou += listA.get(listA.size()-1);
        }
        System.out.println(String.format("%.2f",(double)sum-(double)zhekou/2));;
    }
}
