import java.util.Scanner;

//输入和输出
public class demo5 {
    public static void main(String[] args) {
        //输出

        //换行输出和不换行输出
        System.out.println("123");//换行输出
        System.out.print("456");
        System.out.print("789\n");//这里输出并没有换行


        //格式化输出
        double d = 13000000;
        System.out.println(d);//1.3E7
        System.out.printf("%.2f\n", d);//13000000.00
        System.out.printf("%.4f\n", d);//13000000.0000


        //输入
        //读取用户输入
        Scanner scanner = new Scanner(System.in);
        //打印提示
        System.out.print("请输入你的姓名: ");
        //获取输入
        String name = scanner.nextLine();
        //打印提示
        System.out.print("请输入你的年龄: ");
        //获取输入并转换为整型
        int age = scanner.nextInt();

        System.out.printf("姓名：%s 年龄：%d\n", name, age);
    }
}
