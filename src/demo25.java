//创建新线程
public class demo25 {
    public static void main(String[] args) {
        /*Thread t = new MyThread();//指定派生类
        t.start();//启动新线程  这里会调用派生类的run方法

        //创建Thread实例的时候传入MyRunnable实例
        Thread t1 = new Thread(new MyRunnable());
        t1.start();//这里调用start才会创建线程,调用run只会执行run方法

        Thread t2 = new Thread(()->{
            System.out.println("start new thread--MyThread of lamba");
        });

        t2.start();*/

        /**
         * main线程执行顺序是先打印main start 再打印main end
         * t3线程的执行顺序是先打印thread start 再打印thread end
         * main end 和thread start 还有thread end之间的顺序无法确定，因为调用start方法之后 ，两个线程开始并行。
         * 由操作系统调度，程序本身无法确定线程的调度顺序。
         */
        System.out.println("main start...");
        Thread t3 = new Thread(){
            public void run() {
                System.out.println("thread run...");
                /*try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}*/
                System.out.println("thread end.");
            }
        };

        t3.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {}
        System.out.println("main end...");

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread--MyThread");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new thread--MyRunnable");
    }
}
