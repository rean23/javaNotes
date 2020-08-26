//面向对象-接口
public class demo12 {
    public static void main(String[] args) {
        Bird1 bird = new Parrot1();

        bird.test();
    }
}

/**
 * 所谓interface，就是比抽象类还要抽象的纯抽象接口，因为它连字段都不能有。因为接口定义的所有方法默认都是public abstract的，所以这两个修饰符不需要写出来（写不写效果都一样）。
 */
interface Bird1 {

    //default方法  实现类不需要覆写default 接口和抽象类的方法不同,前者无法定义字段属性 所以 default无法访问字段.而后者可以.
    default void test() {
        System.out.println("this is default");
    }
}

//接口间的继承用extends
interface flyAnimal extends Bird1 {

}

//类可以继承多个接口，类名逗号分隔即可
class Parrot1 implements Bird1 {
    public void fly() {
        System.out.println("Parrot.fly");
    }
}

class Sparrow1 implements Bird1 {
    public void fly() {
        System.out.println("Sparrow.fly");
    }
}

//abstract和interface的区别
/**
 * 	    abstract class	interface
 * 继承	只能extends一个class	可以implements多个interface
 * 字段	可以定义实例字段	不能定义实例字段
 * 抽象方法	可以定义抽象方法	可以定义抽象方法
 * 非抽象方法	可以定义非抽象方法	可以定义default方法
 */
