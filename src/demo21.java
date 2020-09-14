import java.util.*;

//集合
public class demo21 {
    public static void main(String[] args) {
        String[] list = new String[5];//声明可以持有5个字符串对象数组
        list[0] = "rean";

        System.out.println(list[0]);

        /**
         * Collection包含三种类型的集合：
         * List：一种有序列表的集合，例如，按索引排列的Student的List；
         * Set：一种保证没有重复元素的集合，例如，所有无重复名称的Student的Set；
         * Map：一种通过键值（key-value）查找的映射表集合，例如，根据Student的name查找对应Student的Map。
         */

        /**
         * list集合
         */
        List<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("RedApple");
        list1.add("GreenApple");
        list1.add("Apple");//可以添加重复元素

        System.out.println(list1.size());

        //for循环遍历
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

        //迭代器遍历  效率最高
        for (Iterator<String> item = list1.iterator(); item.hasNext();) {
            System.out.println(item.next());
        }

        //foreach本身就使用了Iterator遍历,上面的代码简化版如下：
        for (String item:list1) {
            System.out.println(item);
        }

        //list和array转换
        Object[] array = list1.toArray();
        for (Object item:array) {
            System.out.println(item);
        }

        List<Integer> list3 = new ArrayList<>();
        list3.add(12);
        list3.add(34);
        list3.add(56);
        list3.add(12);
        //Integer[] arr = list3.toArray(new Integer[3]);
        //Number[] arr = list3.toArray(new Number[list3.size()]);//创建一个刚好长度的数组
        //Number[] arr = list3.toArray(new Number[1]);//如果传入的数组不够大，那么List内部会创建一个新的刚好够大的数组，填充后返回
        Number[] arr = list3.toArray(new Number[4]);//如果传入的数组比List元素还要多，那么填充完元素后，剩下的数组元素一律填充null。


        System.out.println(arr.toString());
        for (Number n : arr) {
            System.out.println(n);
        }

        //判断是否包含某个元素
        System.out.println(list3.contains(12));
        System.out.println(list3.indexOf(12));//返回元素对应的索引  -1为找不到
        //System.out.println(list3.lastIndexOf(12));//返回元素对应的索引  -1为找不到

        //new String("Apple")和列表中的Apple不是同一个实例 却依旧相等,因为内部使用的是equals方法判断的。
        System.out.println(list1.contains(new String("Apple")));
        System.out.println(list1.indexOf(new String("Apple")));

        Person2 p = new Person2("xiao hong",12);
        Map<String,Person2> map= new HashMap<>();
        map.put("xm",p);

        Person2 personInfo = map.get("xm");
        System.out.println(personInfo == p);
        System.out.println(personInfo.equals(p));
        System.out.println(personInfo.name);
        System.out.println(personInfo.hashCode());

        /**
         * 本质上HashMap也是使用数组存储,key值采用的是key对象的hashCode方法计算出的索引值，值采用Entry对象，它用来存储key-value对。
         * 那么问题来了  这个数组的长度是怎么样的呢？
         * 数组初始长度为16，任何key都可以通过：
         * int index = key.hashCode() & 0xf;//计算出索引值
         * 第二个问题是：如果索引超出长度，会如何：
         * 数组会自动扩容，每次扩容一倍,但是扩容的性能消耗大 所以最好再创建hashMap的时候就指定容量：
         * Map<String, Integer> map = new HashMap<>(10000);
         * HashMap内部的数组长度永远是2的n次方，所以实际长度是2的14次方也就是16384
         * 如果两个不同的key,hashCode计算出的索引一样，结果会如何？
         * java是通过拉链法来解决此种情况的。
         * HashMap的运行原理如下：
         * 当调用put函数的时候，根据key对象的hashCode计算出索引值,如果数组里此索引上没有值,则直接存储Entry对象。
         * 如果数组此索引上有值,则使用equals函数判断key值是否相等,相等则直接覆盖值,不等的话表示是不同key计算出了相同的hashCode
         * 所以会有两种处理方法：
         * 1.以链表形式存储
         * 2.如果链表已存在并且长度过长则会转为红黑树
         *
         * 当调用get函数的时候，同样还是计算hash值，如果key是null，则索引永远为0，找寻索引对应的Entry对象.找不到就返回null。
         * 找到后迭代链表比对key是否相等,相等则返回value，否则返回null。
         * 既然是迭代链表，则链表太长就会影响性能,所以hashCode()能不相等就不要相等，提高唯一性。
         *
         * 原理差不多就是这样，实际可能会有些许不同。
         */
    }
}

class Person2 {
    public String name;
    public int age;

    public Person2(String name,int age) {
        this.name = name;
        this.age = age;
    }
}

