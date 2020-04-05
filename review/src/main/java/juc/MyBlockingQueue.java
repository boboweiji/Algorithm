package juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue {
    public static interface ArrayBlockingQueue<E> {

        void put(E e) throws InterruptedException;

        E take() throws InterruptedException;
    }

    public static class ArrayBlockingQueueByLock<E> implements ArrayBlockingQueue<E> {
        // 存放队列内容  循环队列
        final Object[] items;

        // 阻塞队列容量
        private int capacity;

        // 队列实际大小
        private int count;

        // put时的下标
        private int putIndex;

        // take时的下标
        private int takeIndex;

        private ReentrantLock lock;
        private Condition notEmpty;
        private Condition notFull;

        public ArrayBlockingQueueByLock(int capacity) {
            this(capacity, false);
        }

        public ArrayBlockingQueueByLock(int capacity, boolean fair) {
            if (capacity <= 0)
                throw new IllegalArgumentException();
            this.capacity = capacity;
            this.count = 0;
            this.items = new Object[capacity];

            lock = new ReentrantLock(fair);
            notEmpty = lock.newCondition();
            notFull =  lock.newCondition();
        }

        @Override
        public void put(E e) throws InterruptedException {
            ReentrantLock lock = this.lock;
            lock.lockInterruptibly();
            try {
                while (capacity == count)
                    notFull.wait();

                enqueue(e);
            } finally {
                lock.unlock();
            }
        }

        public boolean offer(E e) throws InterruptedException {
            ReentrantLock lock = this.lock;
            lock.lockInterruptibly();
            try {
                if (capacity == count)
                    return false;

                enqueue(e);
                return true;
            } finally {
                lock.unlock();
            }
        }

        public E take() throws InterruptedException {
            ReentrantLock lock = this.lock;
            lock.lockInterruptibly();
            try {
                while (0 == count)
                    notEmpty.await();

                return dequeue();
            } finally {
                lock.unlock();
            }
        }

        public E poll() throws InterruptedException {
            ReentrantLock lock = this.lock;
            lock.lockInterruptibly();
            try {
                return 0 == count ? null : dequeue();
            } finally {
                lock.unlock();
            }
        }

        private void enqueue(E x) {
            final Object[] items = this.items;
            items[putIndex++] = x;
            if (putIndex == capacity)
                putIndex = 0;
            count++;

            notEmpty.signal();
        }

        private E dequeue() {
            final Object[] items = this.items;
            E e = (E) items[takeIndex];
            items[takeIndex++] = null;
            if (takeIndex == capacity)
                takeIndex = 0;
            count--;

            notFull.signal();
            return e;
        }

    }


    public static class ArrayBlockingQueueByWait<E> implements ArrayBlockingQueue<E> {
        private Object[] items;

        private int capacity;

        private int count;

        private int putIndex;

        private int takeIndex;

        private Object lock = new Object();

        public ArrayBlockingQueueByWait(int capacity) {
            if (capacity <= 0)
                throw new IllegalArgumentException();
            this.capacity = capacity;
            this.items = new Object[capacity];
        }

        public void put(E e) throws InterruptedException {
            synchronized (lock) {
                while (count ==  capacity)
                    lock.wait();

                enqueue(e);
            }
        }

        public E take() throws InterruptedException {
            synchronized (lock) {
                while (0 == count)
                    lock.wait();

                return dequeue();
            }
        }

        private void enqueue(E e) {
            items[putIndex++] = e;
            if (putIndex == capacity)
                putIndex = 0;
            count++;


            lock.notify();
        }

        private E dequeue() {
            E e  = (E) items[takeIndex];
            items[takeIndex++] = null;
            if (takeIndex == capacity)
                takeIndex = 0;
            count--;

            lock.notify();
            return e;
        }
    }



    public static void main(String[] args) {
        ArrayBlockingQueueByLock<String> arrayBlockingQueueByLock
                = new ArrayBlockingQueueByLock<>(16);

        ArrayBlockingQueueByWait<String> arrayBlockingQueueByWait
                = new ArrayBlockingQueueByWait<>(16);

        Thread takeThread = new Thread(new TakeTask(arrayBlockingQueueByWait));
        Thread putThread = new Thread(new PutTask(arrayBlockingQueueByWait));

        takeThread.start();
        putThread.start();
    }


    /**
     * 模拟两个线程 一个获取  一个放入
     */

    public static class TakeTask implements Runnable {

        ArrayBlockingQueue arrayBlockingQueue;

        public TakeTask(ArrayBlockingQueue arrayBlockingQueue) {
            this.arrayBlockingQueue = arrayBlockingQueue;
        }

        @Override
        public void run() {
            try {
                System.out.println("take start :  " + System.currentTimeMillis());
                Object take = arrayBlockingQueue.take();
                System.out.println("take :  " + take + "    " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class PutTask implements Runnable {

        ArrayBlockingQueue arrayBlockingQueue;

        public PutTask(ArrayBlockingQueue arrayBlockingQueue) {
            this.arrayBlockingQueue = arrayBlockingQueue;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("put :  " + "    " + System.currentTimeMillis());
                arrayBlockingQueue.put("hahah");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
