import java.util.*;

public class TestArrayList {
    public static void main(String[] args) {
        /*String[] s = {"cat","dog"};
        List<String> as = Arrays.asList(s);
        //as.add("s"); //java.lang.UnsupportedOperationException
        s[0] = "bear";
        System.out.println(as.toString());*/
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        for(String item : list){
            if("1".equals(item)||"2".equals(item)){   //详见https://juejin.im/entry/5c7c7cae518825620677eebb
                list.remove(item);  //隐式的iterator由于没有重新设置expectedModCount，隐式的iterator.next()会报ConcurrentModificationException
            }
        }

        /*Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String item = iterator.next();
            if(item.equals("2")){
                iterator.remove();
            }
        }*/
        System.out.println(list.toString());
    }
}
