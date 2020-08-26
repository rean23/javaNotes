//面向对象-继承
public class demo9 {

    public static void main(String[] args) {
        Student student = new Student();

        //如果People的字段里name是private 这里ide会发出警告  'name' has private access in 'People'
        System.out.println(student.name);
        System.out.println(student.getUserInfo());

        //向上转型(自动转换)
        People people = new Student();
        //System.out.println(people.getUserInfo());//这里是解析不到方法的，因为变量指向的是父类


        //向下转型(强制转换)
        People p1 = new Student();
        People p2 = new People("Rean",26);

        Student s1 = (Student) p1;
        //Student s2 = (Student) p2;//ClassCastException 因为这里p2指向的是父类  子类比父类多出来的方法和属性 无法凭空制造

        //使用instanceof 在向下转型之前可以使用instanceof进行判断
        System.out.println(p2 instanceof Student);
    }
}

/**
 * 在OOP的术语中，我们把Person称为超类（super class），父类（parent class），基类（base class），把Student称为子类（subclass），扩展类（extended class）
 */

//定义people类的时候没有写extends 但是编译的时候会加上extends Object 所以任何类 除了object 都会继承某个类
//Java只允许一个class继承自一个类，因此，一个类有且仅有一个父类。只有Object特殊，它没有父类。
class People {
    //protected 子类可以继承访问
    protected String name;
    //private字段 子类无法访问
    private int age;
    public Foo foo;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}

//继承的特点就是  子类无法访问父类的private字段或者private方法 比如Student就不能访问父类的字段和方法
class Student extends People {

    public Student() {
        //在java中,任何class的构造方法，第一句必须调用父类的构造方法，如果没有明确调用父类的构造方法，编译器会在第一句加上super();
        //但是这里父类的构造方法需要传参,所以需要显式调用
        super("Beckham", 38);
    }

    public String getUserInfo() {
        return super.name;//这里的super和this作用一样 都是调用属性
    }
}

//如果父类没有默认的构造方法，子类就必须显式调用super()并给出参数以便让编译器定位到父类的一个合适的构造方法。
//即子类不会继承任何父类的构造方法。子类默认的构造方法是编译器自动生成的，不是继承的。


class Foo {
    public void bar() {
        System.out.println("foo.bar");
    }

}