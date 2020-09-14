//死锁
public class demo28 {
    public static void main(String[] args) {
        Counter1 c1 = new Counter1();
        Counter1 c2 = new Counter1();

        //这里synchronized锁住的是this 当前实例, 所以两个实例的锁并不会互相影响
        new Thread(() -> {
            c1.add(1);
        }).start();

        new Thread(() -> {
            c1.dec(1);
        }).start();

        new Thread(() -> {
            c2.add(1);
        }).start();

        new Thread(() -> {
            c2.dec(1);
        }).start();

        System.out.println(c1.get());
        System.out.println(c2.get());

        /**
         * 对于Counter1,是允许多线程正确调用的。
         * 如果一个类被设计为允许多线程正确访问，我们就说这个类就是“线程安全”的（thread-safe）,例如Counter1.
         * 如果方法是静态方法  则锁住的是该类的Class实例
         */

        new Thread(() -> {
            c1.add2(1);
        }).start();
        new Thread(() -> {
            c1.dec2(1);
        }).start();
        System.out.println(c1.get2());
    }
}

class Counter1 {
    private int count = 0;
    private int value = 0;
    private int another = 0;
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    //synchronized可以用来修饰方法  和下面写法等价
    public synchronized void add(int n) {
        this.count += n;
    }

    public void dec(int n) {
        synchronized (this) {
            this.count -= n;
        }
    }

    //这里没有用synchronized是因为只是获取一个int变量,如果是有多个赋值语句的话,则需要使用synchronized
    public int get() {
        return this.count;
    }

    //对于同一线程，JVM允许同一个线程重复获取同一个锁，这种锁的名字被称为重入锁
    //由于Java的线程锁是可重入锁，
    //所以，获取锁的时候，不但要判断是否是第一次获取，还要记录这是第几次获取。
    // 每获取一次锁，记录+1，每退出synchronized块，记录-1，减到0的时候，才会真正释放锁。
    public synchronized void add1(int n) {
        if (n < 0) {
            this.dec(-n);
        } else {
            this.add(n);
        }
    }

    /**
     * 两个线程各自持有不同的锁，然后各自试图获取对方手里的锁，造成了双方无限等待下去，这就是死锁。
     * 死锁发生后，没有任何机制能解除死锁，只能强制结束JVM进程。
     * 因此，在编写多线程应用时，要特别注意防止死锁。因为死锁一旦形成，就只能强制结束进程。
     * 那么我们应该如何避免死锁呢？答案是：线程获取锁的顺序要一致。即严格按照先获取lockA，再获取lockB的顺序
     */
    public void add2(int m) {
        System.out.println("add2");
        synchronized (lockA) { // 获得lockA的锁
            System.out.println("add2--获取lockA");
            this.value += m;
            synchronized (lockB) { // 获得lockB的锁
                System.out.println("add2--获取lockB");
                this.another += m;
            } // 释放lockB的锁
        } // 释放lockA的锁
    }

    public void dec2(int m) {
        System.out.println("dec2");
        synchronized(lockB) { // 获得lockB的锁
            System.out.println("dec2--获取lockB");
            this.another -= m;
            synchronized(lockA) { // 获得lockA的锁
                System.out.println("dec2--获取lockA");
                this.value -= m;
            } // 释放lockA的锁
        } // 释放lockB的锁
    }

    public String get2() {
        return this.value + "-" + this.another;
    }

}
