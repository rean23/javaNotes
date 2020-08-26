//导入包

import rean.Person;

public class demo14 {
    public static void main(String[] args) {
        Person p1 = new Person();//import 类之后可以直接实例
        Person p2 = new rean.Person();//也可以输入包的名称
        p1.test();
        p2.test();
    }
}