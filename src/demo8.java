import java.util.Arrays;

public class demo8 {


    public static void main(String[] args) {
        Person person = new Person("rean", 26);
        System.out.println(person.name + ", " + person.age);


        person.setName("rean");
        person.setAge(29);
        System.out.println(person.name + ", " + person.age);


        String bob = "bob";
        person.setName(bob);
        bob = "Alice";
        System.out.println(person.name);


        person.setUserList("Rean", "Ronaldo", "Beckham");
        System.out.println(Arrays.toString(person.getUserList()));

        //相同参数个数的情况下,判断类型
        person.talk(26,"rean");
        person.talk("rean",26);
    }
}

class Person {
    public String name;
    public int age;
    private String[] userList;

    /**
     * 构造方法
     *
     * @param name
     * @param age
     */
    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    //多构造函数  根据参数个数匹配
    public Person(String name) {
    }

    public Person() {
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //可变参数
    public void setUserList(String... userList) {
        this.userList = userList;
    }

    public String[] getUserList() {
        return userList;
    }

    //重载 和定义多个构造函数一样 根据参数来进行匹配
    public void talk() {

    }
    public void talk(String str) {}
    public void talk(String str,int type) {
        System.out.println("talk3");
    }
    public void talk(int type,String str) {
        System.out.println("talk4");
    }


}


