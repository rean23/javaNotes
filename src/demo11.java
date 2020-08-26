//面向对象-抽象类
public class demo11 {
    public static void main(String[] args) {
        //Bird bird = new Bird();//无法实例抽象类 抽象类只是用来实现一种规范

        /**
         * 通过抽象规范去引用子类,可以不去考虑子类的具体实现
         * 这里称为面向抽象编程
         * 面向抽象编程的本质就是：
         * 上层代码只定义规范（例如：abstract class Bird）；
         * 不需要子类就可以实现业务逻辑（正常编译）；
         * 具体的业务逻辑由不同的子类实现，调用者并不关心。
         */
        Bird parrot = new Parrot();
        Bird sparrow = new Sparrow();
    }
}

//需要声明抽象类
abstract class Bird {
    //public void fly();//去掉父类方法的执行语句则会报错
    public abstract void fly();//声明为抽象方法  但是会报错 因为类不是抽象类
}

class Parrot extends Bird {
    public void fly() {
        System.out.println("Parrot.fly");
    }
}

class Sparrow extends Bird {
    public void fly() {
        System.out.println("Sparrow.fly");
    }
}