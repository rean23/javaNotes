//类型运算
public class demo2 {
    public static void main(String[] args) {

        /**
         * 整数的数值表示不但是精确的，而且整数运算永远是精确的，即使是除法也是精确的，因为两个整数相除只能得到结果的整数部分：
         */
        int i1 = 10 / 3;//3
        System.out.println(i1);

        //int i2 = 10/0;//整数的除法对于除数为0时运行时将报错，但编译不会报错。
        //System.out.println(i2);

        /**
         * 数据溢出
         */
        int x = 2147483640;
        int y = 15;
        int sum = x + y;//-2147483641 换为long类型则可解决
        System.out.println(sum);

        /**
         * 简写运算符
         */
        int n = 100;
        n += 100;//相当于n=n+100
        System.out.println(n);//200
        n -= 100;//相当于n=n-100
        System.out.println(n);//100

        int n1 = 200;
        n1++;
        System.out.println(n1);//201
        n1--;
        System.out.println(n1);//200
        /**
         * 注意++写在前面和后面计算结果是不同的，++n表示先加1再引用n，n++表示先引用n再加1。不建议把++运算混入到常规运算中，容易自己把自己搞懵了
         */

        /**
         * 二进制知识点:
         * 二进制的最高位是符号位（“0”代表正数，“1”代表负数）；
         * Java中没有无符号数；
         * 计算机以整数的补码进行运算；
         */

        /**
         * 原码 将一个整数转为二进制显示
         * 以 int 类型为例，int类型占4个字节、共32位。
         * 例如，2 的原码为：00000000 00000000 00000000 00000010
         *      -2的原码为：10000000 00000000 00000000 00000010
         * 反码
         * 正数的反码：与原码相同
         * 负数的反码：原码的符号位不变，其他位取反
         * 例如-2的反码为:11111111 11111111 11111111 11111101
         *
         * 补码
         * 正数的补码：与原码相同
         * 负数的补码：负数的反码+1(把反码当做一个整数+1)
         * 例如-2的反码为：11111111111111111111111111111110 这里最后一位逢2进1 所以补码是10
         */

        //按位与 &：必须两个数同时为1，结果才为1
        /**
         *  2的原码为： 00000000 00000000 00000000 00000010
         *  3的原码为： 00000000 00000000 00000000 00000011
         *  计算结果 00000000 00000000 00000000 00000010=2
         */
        int a = 2 & 3;
        System.out.println(a);//2

        //按位或 |：只要任意一个为1，结果就为1
        /**
         * 2的原码为： 00000000 00000000 00000000 00000010
         * 3的原码为： 00000000 00000000 00000000 00000011
         * 计算结果 00000000 00000000 00000000 00000011=3
         */
        a = 2 | 3;
        System.out.println(a);//3

        //按位异或 ^：如果两个数不同，结果为1，否则为0
        /**
         *  2的原码为： 00000000 00000000 00000000 00000010
         *  3的原码为： 00000000 00000000 00000000 00000011
         *  计算结果 00000000 00000000 00000000 00000001=1
         */
        a = 2 ^ 3;
        System.out.println(a);//1

        //非运算符
        /**
         * 1.符号位不变，按位取反
         * 2.符号位为0（整数）：取反的结果-1，符号位为1（负数），取反结果+1
         * 3.包含符号位，按位取反
         * 2的原码为:00000000 00000000 00000000 00000010
         *          01111111 11111111 11111111 11111101
         *          01111111 11111111 11111111 11111100
         *          10000000 00000000 00000000 00000011
         *          得出3 因为符号位为1  所以为负数 则结果为-3
         */
        System.out.println(~2);//-3


        //类型自动提升
        short s1 = 1234;
        int s2 = 5678;

        int b1 = s1 + s2;
        short b2 = (short) (s1 + s2);//这里ide会报错 因为short类型提升为int 只能进行类型强制转换
        System.out.println(b1);//6912
        System.out.println(b2);//6912 经过强制转换的数值很可能会不准确


        //浮点运算 浮点数运算和整数运算相比，只能进行加减乘除这些数值计算，不能做位运算和移位运算。

        double d = 1.0 / 10;
        double d1 = 1 - 9.0 / 10;

        //浮点数0.1在计算机中就无法精确表示，因为十进制的0.1换算成二进制是一个无限循环小数，很显然，无论使用float还是double，都只能存储一个0.1的近似值。但是，0.5这个浮点数又可以精确地表示。
        System.out.println(d);//0.1
        System.out.println(d1);//0.09999999999999998

        //类型提升 如果参与运算的两个数其中一个是整型，那么整型可以自动提升到浮点型
        int num = 5;
        double num1 = 1.2 + 24.0 / num;
        System.out.println(num1);//6.0

        double num2 = 1.2 + 24 / 5;
        System.out.println(num2);//5.2 因为这里计算24/5的时候两个整数计算结果为4


        /**
         * 除以0的时候会返回几个特殊值
         * NaN表示Not a Number
         * Infinity表示无穷大
         * -Infinity表示负无穷大
         */
        double num3 = 0.0 / 0;
        double num4 = 1.0 / 0;
        double num5 = -1.0 / 0;
        System.out.println(num3);//NaN
        System.out.println(num4);//Infinity
        System.out.println(num5);//-Infinity

        //强制转换
        int foo1 = (int) 12.3;
        int foo2 = (int) -12.3;
        int foo3 = (int) 1.2e20;

        System.out.println(foo1);//12
        System.out.println(foo2);//-12
        System.out.println(foo3);//2147483647 超过int类型的最大范围


        //布尔运算
        boolean isGreater = 5 > 3; // true
        int age = 12;
        boolean isZero = age == 0; // false
        boolean isNonZero = !isZero; // true
        boolean isAdult = age >= 18; // false
        boolean isTeenager = age > 6 && age < 18; // true


        //短路运算 布尔运算的一个重要特点是短路运算。如果一个布尔运算的表达式能提前确定结果，则后续的计算不再执行，直接返回结果。

        boolean isMax = 5 < 3;
        boolean result = isMax && (5 / 0 > 0);
        System.out.println(result);//如果没有短路运算  则&&后面的语句会报错 如果把isMax的结果改为true则报错

        boolean result1 = true || (5 / 0 > 0);//换成或运算符 后面语句也不执行
        System.out.println(result1);

        //三元运算符
        int age1 = 26;
        int result2 = n >= 0 ? 1 : 2;
        System.out.println(result2);
    }
}
