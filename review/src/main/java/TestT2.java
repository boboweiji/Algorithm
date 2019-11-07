public class TestT2 {


    public static void main(String[] args) throws ClassNotFoundException {


        TT tt = new TT();
        System.out.println(tt.tt);

        ClassLoader.getSystemClassLoader().loadClass("TT2");


        ClassLoader.getSystemClassLoader().loadClass("TT2");
    }

    public static class c1 {
        c2 c;
        static {
            System.out.println("C1");
        }
    }

    public static class c2 {
        static {
            System.out.println("C2");
        }
    }
}
