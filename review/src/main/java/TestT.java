import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TestT {
    //注意：Number并没有实现Comparable
    private static <T extends Number & Comparable<? super T>> T min(T[] values) {
        if (values == null || values.length == 0) return null;
        T min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (min.compareTo(values[i]) > 0) min = values[i];
        }
        return min;
    }

    public static void main(String[] args) {
//        int minInteger = min(new Integer[]{1, 2, 3});//result:1
//        double minDouble = min(new Double[]{1.2, 2.2, -1d});//result:-1d
//        System.out.println("minInteger:"+minInteger+"   minDouble"+minDouble);
        //String typeError = min(new String[]{"1","3"});//报错
        //String oldName = "123.pdf";
        //System.out.println(oldName.substring(oldName.lastIndexOf(".")).toLowerCase());

        String path = "D:/xpj/";
        File file1 = new File(path+"temp/"+"1-1.txt");
        String nextPath = path+"test";
        File dir = new File(nextPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file2 = new File(nextPath+"/2.txt");
        try {
            Files.copy(file1.toPath(),file2.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        File newDir = new File(nextPath+"/test1");
        if (!newDir.exists()) {
            newDir.mkdirs();
        }

        File file3 = new File(nextPath+"/test1"+"/3.txt");
        try {
            Files.copy(file1.toPath(),file3.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
