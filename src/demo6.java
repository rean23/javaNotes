//流程控制
public class demo6 {
    public static void main(String[] args) {
        //if语句
        short type = 3;

        //判断基本类型
        if (type == 1) {
            System.out.println("付款");
        } else if (type == 2) {
            System.out.println("退款");
        } else {
            System.out.println("未知操作");
        }

        System.out.println("结束");


        //判断引用类型
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();

        //这里的逻辑运算会返回false  因为两个字符串是不同的字符串对象 不能使用==判断 需要使用
        //if (s1 == s2) {
        if (s1.equals(s2)) {
            System.out.println("相等");
        } else {
            System.out.println("不等");
        }


        //switch语句
        int handle = 4;
        switch (handle) {
            case 1:
                System.out.println("case 1");
                break;
            case 2:
                System.out.println("case 2");
                break;
            case 3:
                System.out.println("case 3");
                break;
            default:
                System.out.println("default");
                break;
        }

        //while循环
        int num = 1;
        while (num <= 100) {
            System.out.println(num);
            num++;
        }

        //do while循环  至少执行一次
        int num1 = 101;
        do {
            System.out.println(num1);
            num1++;
        } while (num1 <= 100);

        //for循环
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }

        for (int i = 0; ; ) {
            System.out.println(i);
            break;//跳出当前循环  continue;作用是跳出本次循环
        }

        //foreach循环
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        for (int i : arr
        ) {
            System.out.println(i);
        }
    }
}
