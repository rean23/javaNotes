//面向对象-多态
public class demo10 {
    public static void main(String[] args) {
        Animal dog = new Dog();

        //Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型。 这里称为多态
        dog.run();//dog.run
    }
}

class Animal {
    public final int legNum = 4;//被final修饰的属性初始化后不能被修改 在构造方法里也可以初始化
    public void run() {
        System.out.println("animal.run");
    }

    //用final修饰的方法不能被重写 同理被final修饰的类也不能被继承 如final class Animal
    public final void eat() {
        System.out.println("animal.eat");
    }
}

class Dog extends Animal {
    @Override //这里覆写父类的run方法
    public void run() {
        super.run();//调用父类被覆写的方法
        System.out.println("dog.run");
    }
}
