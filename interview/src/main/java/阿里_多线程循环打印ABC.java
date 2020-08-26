import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PrintData{
    private int flag = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print(int shu){
        lock.lock();
        try{
            switch (shu) {
                case 1:
                    while (flag != 1){
                        c1.await();
                    }
                    break;
                case 2:
                    while (flag != 2){
                        c2.await();
                    }
                    break;
                case 3:
                    while (flag != 3){
                        c3.await();
                    }
                    break;
                default:
                    break;
            }
            System.out.print(Thread.currentThread().getName());
            switch (shu) {
                case 1:
                    flag = 2;
                    c2.signal();
                    break;
                case 2:
                    flag = 3;
                    c3.signal();
                    break;
                case 3:
                    flag = 1;
                    c1.signal();
                    break;
                default:
                    break;
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class 阿里_多线程循环打印ABC {
    public static void main(String[] args) {
        PrintData printData = new PrintData();

        new Thread(()->{
            for(int i=0; i<10; i++){
                printData.print(1);
            }
        },"A").start();

        new Thread(()->{
            for(int i=0; i<10; i++){
                printData.print(2);
            }
        },"B").start();

        new Thread(()->{
            for(int i=0; i<10; i++){
                printData.print(3);
            }
        },"C").start();
    }
}
