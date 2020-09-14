import java.util.ArrayList;
//泛型
public class demo20 {
    public static void main(String[] args) {

        //Plate<? extends Fruit> p = new Plate<Fruit>(new Fruit());
        /**
         * 编译器认定的逻辑是不能把一个Apple类型传递给一个Fruit类型，就算类之间有继承关系,但是容器之间没有。
         */
        //Plate<Fruit> p = new Plate<Apple>(new Apple());//编译器报错

        //上界 extends 即泛型参数要满足的条件：泛型参数必须是 T 类型或它的子类
        /**
         * 这里的意思是能放Fruit以及它的所有派生类 包括Fruit Apple RedApple GreenApple
         * Plate<？ extends Fruit>和Plate<Apple>最大的区别就是：
         * Plate<？ extends Fruit>是Plate<Fruit>及Plate<Apple>的基类
         */
        Plate<? extends Fruit> p1 = new Plate<Apple>(new Apple());

        //不能往里存，只能往外取
        /**
         * 编译器只能识别容器内是Fruit或者它的所有派生类，具体不知道。
         * 编译器会先标上占位符capture#1,来表示捕获一个Fruit或Fruit的子类，具体是什么类不知道.
         * 写入的Apple或者Pork无法确定能和capture#1进行匹配，所以报错
         * 错误信息：Error:(19, 16) java: 不兼容的类型: Fruit无法转换为capture#1, 共 ? extends Fruit
         */
        //p1.set(new Fruit());//错误
        //p1.set(new Apple());//错误

        //Apple fruit1 = p1.get();//错误
        //Fruit fruit2 = p1.get();
        //Object fruit3 = p1.get();

        //下界 super
        /**
         * 与extends相反,意思是能放Fruit以及它的基类 包括Fruit Food
         * Plate<？ super Fruit>是Plate<Fruit>的基类，但不是Plate<Apple>的基类
         */
        Plate<? super Fruit> p2 = new Plate<Food>(new Food());

        //不影响往里存
        p2.set(new Fruit());
        p2.set(new Apple());

        //但往外取只能放在Object对象里
        //Apple fruit1 = p2.get();//错误
        //Fruit fruit2 = p2.get();//错误
        //Object fruit3 = p2.get();

        /**
         * PECS原则
         * PECS（Producer Extends Consumer Super）原则:
         * 1、频繁往外读取内容的，适合用上界Extends。
         * 2、经常往里插入的，适合用下界Super。
         * 即：如果需要返回T，它是生产者（Producer），要使用extends通配符；
         * 如果需要写入T，它是消费者（Consumer），要使用super通配符。
         */
    }

}

//第一级
class Food{}

//第二级
class Fruit extends Food{}
class Meat extends Food{}

//第三级
class Apple extends Fruit {}
class Pork extends Meat {}
class Beef extends Meat {}

//第四级
class RedApple extends Apple{}
class GreenApple extends Apple{}

class Plate<T> {
    private T item;

    public Plate(T t) {
        this.item = t;
    }

    public void set(T t) {
        this.item = t;
    }

    public T get() {
        return this.item;
    }
}