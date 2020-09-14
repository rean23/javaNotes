public class demo26 {
    public static void main(String[] args) {
        /**
         * 在java程序中，一个线程对象只能调用一次start启动新线程，并在新线程执行run()方法，一旦run()执行完毕，
         * 线程就结束了。所以线程的状态有以下几种：
         * New：新创建的线程，尚未执行；
         * Runnable：运行中的线程，正在执行run()方法的Java代码；
         * Blocked：运行中的线程，因为某些操作被阻塞而挂起；
         * Waiting：运行中的线程，因为某些操作在等待中；
         * Timed Waiting：运行中的线程，因为执行sleep()方法正在计时等待；
         * Terminated：线程已终止，因为run()方法执行完毕。
         *
         * 线程中止的原因：
         * 线程正常终止：run()方法执行到return语句返回；
         * 线程意外终止：run()方法因为未捕获的异常导致线程终止；
         * 对某个线程的Thread实例调用stop()方法强制终止（强烈不推荐使用）。
         */
        try {
            Thread t = new Thread(() -> {
                System.out.println("hello,rean");
            });

            System.out.println("start");
            t.start();//启动线程之后
            t.join();//通过join方法等待线程结束后再执行
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
