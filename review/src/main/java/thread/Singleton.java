package thread;

public class Singleton {

    private volatile static Singleton uniqueInstance; // volatile 可以禁止 JVM 的指令重排，还有其他特性详见（https://www.jianshu.com/p/ccfe24b63d87）

    private Singleton() {
    }

    public static Singleton getUniqueInstance() {
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码（https://www.cnblogs.com/GtShare/p/9274237.html）
        if (uniqueInstance == null) {
            //类对象加锁，保证只会新建一个实例
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}