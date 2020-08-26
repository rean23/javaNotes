import java.lang.reflect.Field;
import java.lang.reflect.Method;

//反射
public class demo17 {
    public static void main(String[] args) {
        try {
//            Class cls1 = Class.forName("Foo2");
            //每加载一种class，JVM就为其创建一个Class类型的实例，并关联起来。注意：这里的Class类型是一个名叫Class的class。
            //动态加载-JVM在执行Java程序的时候，并不是一次性把所有用到的class全部加载到内存，而是第一次需要用到class时才加载。
            Foo2 foo2 = new Foo2();
            System.out.println(foo2.getClass());//这里可以获取实例对应的Class实例信息

            /**
             * 获取Class实例
             * 方法一：直接通过一个class的静态变量class获取：
             * 方法二：如果我们有一个实例变量，可以通过该实例变量提供的getClass()方法获取：
             * 方法三：如果知道一个class的完整类名，可以通过静态方法Class.forName()获取：
             */
            Class cls1 = Class.forName("java.lang.String");
            Class cls2 = "a".getClass();
            System.out.println(cls1 == cls2);//true 这两句获取的都是同一个类的实例

            /**
             * 获取字段方法
             * Field getField(name)：根据字段名获取某个public的field（包括父类）
             * Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
             * Field[] getFields()：获取所有public的field（包括父类）
             * Field[] getDeclaredFields()：获取当前类的所有field（不包括父类）
             */
            Class foo = Foo2.class;
            Field scoreField = foo.getDeclaredField("score");
            System.out.println(scoreField.getModifiers());

            //多态
            Method cls5 = Base1.class.getMethod("hi");
            cls5.invoke(new Childen1());//Childen1.hi  遵循多态原则：即总是调用实际类型的覆写方法
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Foo2 {

    private int score;
    public int age;

    //随着类的加载而执行，只执行一次，并优先于主函数
    static {
        System.out.println("执行了静态代码块");
    }

    public void bar() {
        System.out.println("bar");
    }
}

class Base1 {
    public void hi() {
        System.out.println("Base1.hi");
    }
}

class Childen1 extends Base1{
    public void hi() {
        System.out.println("Childen1.hi");
    }
}
