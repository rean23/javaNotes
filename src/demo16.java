import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

//异常处理
public class demo16 {
    public static void main(String[] args) {

        /**
         * Throwable是异常体系的根，它继承自Object。Throwable有两个体系：Error和Exception，Error表示严重的错误，程序对此一般无能为力，例如：
         * OutOfMemoryError：内存耗尽
         * NoClassDefFoundError：无法加载某个Class
         * StackOverflowError：栈溢出
         * 而Exception则是运行时的错误，它可以被捕获并处理。例如：
         * NumberFormatException：数值类型的格式错误
         * FileNotFoundException：未找到文件
         * SocketException：读取网络失败
         */

        //一般不建议这么写  因为意味着一旦发生异常 就意味着程序终止运行 在toGBK方法里捕获
//        try {
        byte[] bs = toGBK("中国");
        System.out.println(Arrays.toString(bs));
//        } catch(UnsupportedEncodingException e) {
//            System.out.println(e.getMessage());
//        }

        //捕获 多个异常
        /*try {

        } catch (FileNotFoundException e) {

        } catch (UnsupportedEncodingException|NoSuchMethodException e) {//多个异常

        //无论是否捕获异常都会执行finally里的代码块 finally可写可不写  最终都是最后执行
        } finally {

        }*/
        System.out.println(int.class.getName());
        try {
//            foo1();
            Integer.parseInt("abc");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch");
            throw new RuntimeException(e);
        //这里finally会先执行
        } finally {
            //finally里面如果抛出异常的话  会覆盖catch里抛出的异常
            System.out.println("finally");
            throw new IllegalArgumentException();
        }
    }

    static byte[] toGBK(String s) {//这里表明会抛出的异常类型
        try {
            return s.getBytes(s);//这里会报错 Unhandled exception: java.io.UnsupportedEncodingException 因为未对异常进行捕获
        } catch (UnsupportedEncodingException e) {
            //写入异常日志
            //System.out.println(e.printStackTrace());//获取异常信息
        }

        return null;
    }

    static void foo1() {
        try {
            foo2();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static void foo2() {
        throw new NullPointerException();
    }
}
