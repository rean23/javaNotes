//字符与字符串
public class demo3 {
    public static void main(String[] args) {

        //字符类型
        char c1 = 'A';
        char c2 = '中';
        System.out.println(c1);//A
        System.out.println(c2);//中

        //如果要获取字符对应的unicode码
        int i1 = c1;
        int i2 = c2;
        System.out.println(i1);//65
        System.out.println(i2);//20013

        //通过unicode码来表示字符
        char c3 = '\u0041'; // 'A'，因为十六进制0041 = 十进制65
        char c4 = '\u4e2d';
        System.out.println(c3);//A
        System.out.println(c4);//中


        //字符串类型
        String s = ""; // 空字符串，包含0个字符
        String s1 = "A"; // 包含一个字符
        String s2 = "ABC"; // 包含3个字符
        String s3 = "中文 ABC"; // 包含6个字符，其中有一个空格

        System.out.println(s1 + s2 + s3);//加号链接字符串

        //多行字符串
        String s4 = "first line\n"
                + "secont line\n"
                + "last line\n"
                + "end";

        System.out.println(s4);

        //不可变特性
        String s5 = "hello";
        String s6 = s5;

        s5 = "world";//这里是s5变量指向了world这个z字符串 hello还在
        System.out.println(s5);//world
        System.out.println(s6);//hello


        //空值null 引用类型的变量可以指向一个空值null，它表示不存在，即该变量不指向任何对象
        String s7 = null;//null
        String s8;//null
        String s9 = s7;//null
        String s10 = "";//这里是空字符串
    }
}
