//面向对象--静态字段和静态方法
public class demo13 {
    public static void main(String[] args) {
        Parrot2 p1 = new Parrot2();
        Parrot2 p2 = new Parrot2();

        //静态属性属于类本身 不属于实例 所以所有实例共享静态字段
        p1.score = 100;
        System.out.println(p2.score);//不推荐写法
        System.out.println(Parrot2.score);//推荐写法
        Parrot2.test();
    }
}

class Parrot2 {
    public String name;
    public int age;

    public static int score;

    //定义静态方法
    public static void test() {
        System.out.println("this is parrot2");
    }
}


interface Bird2 {
    //接口类可以定义字段
    //public static final int NUM1 = 1;
    //public static final int NUM2 = 2;

    //简写 public static final int编译器会自动加上
    int NUM1 = 1;
    int NUM2 = 2;
}
