//数据类型

public class demo1 {
    public static void main(String[] args) {
        /*
         * 基本运算赋值
         *
         * */
        /*int x = 1;
        System.out.println(x);
        x = 200;
        System.out.println(x);
        int y = x;
        System.out.println(y);*/


        //数据类型

        //整型 范围 -2147483648~2147483647
        /*
        对于整型类型，Java只定义了带符号的整型，因此，最高位的bit表示符号位（0表示正数，1表示负数）。各种整型能表示的最大范围如下：
            byte：-128 ~ 127
            short: -32768 ~ 32767
            int: -2147483648 ~ 2147483647
            long: -9223372036854775808 ~ 9223372036854775807
*       */
        int i = 2147483647;
        int i2 = -2147483648;
        int i3 = 2_000_000_000;
        int i4 = 0xff0000;// 十六进制表示的16711680
        int i5 = 0b1000000000;//二进制表示的512
        long i6 = 1000000000000000000L;//long 类型末尾要加L

        System.out.println(i);//2147483647
        System.out.println(i2);//-2147483648
        System.out.println(i3);//2000000000
        System.out.println(i4);//16711680
        System.out.println(i5);//512
        System.out.println(i6);//1000000000000000000


        //浮点型
        /*
         * 浮点类型的数就是小数，因为小数用科学计数法表示的时候，小数点是可以“浮动”的，如1234.5可以表示成12.345x102，也可以表示成1.2345x103，所以称为浮点数。
         */

        /*
            浮点数可表示的范围非常大，float类型可最大表示3.4x1038，而double类型可最大表示1.79x10308
         */
        float f1 = 3.14f;
        float f2 = 3.14e38f;
        double d1 = 1.79e308;
        double d2 = -1.79e308;
        double d3 = 4.8e-324;

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);

        /**
         * 布尔值
         * 布尔类型boolean只有true和false两个值
         */

        boolean b1 = true;
        boolean b2 = false;
        boolean isGreate = 3 > 2;
        int age = 26;
        boolean checkAge = age > 30;

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(isGreate);
        System.out.println(checkAge);

        /**
         * 字符
         * 字符类型char表示一个字符。Java的char类型除了可表示标准的ASCII外，还可以表示一个Unicode字符
         * 注意char类型使用单引号'，且仅有一个字符，要和双引号"的字符串类型区分开。
         */

        char c1 = 'A';
        char c2 = '中';

        System.out.println(c1);
        System.out.println(c2);


        /**
         * 除了上述基本类型的变量，剩下的都是引用类型。例如，引用类型最常用的就是String字符串
         */
        String s = "hello";
        String a = s;
        a = "world";
        System.out.println(a);
        System.out.println(s);


        /**
         * final 关键字
         * 定义常量，在定义变量的时候加上final修饰符，这个变量就变成了常量
         * 常量在定义时进行初始化后就不可再次赋值，再次赋值会导致编译错误。
         * 常量定义使用大写
         */
        final double PI = 3.1415926;
        System.out.println(PI);

        /**
         * var关键字
         * 有些时候，类型的名字太长，写起来比较麻烦
         */
        StringBuilder sb = new StringBuilder();
        var sa = new StringBuilder();

    }
}
