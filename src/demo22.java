import java.time.DayOfWeek;
import java.util.*;

public class demo22 {
    public static void main(String[] args) {
        //EnumMap 这种类型的HashMap结构紧凑不需要计算hashCode
        Map<DayOfWeek, String> enumMap = new EnumMap<DayOfWeek, String>(DayOfWeek.class);
        enumMap.put(DayOfWeek.MONDAY, "星期一");
        enumMap.put(DayOfWeek.TUESDAY, "星期二");
        enumMap.put(DayOfWeek.WEDNESDAY, "星期三");
        enumMap.put(DayOfWeek.THURSDAY, "星期四");
        enumMap.put(DayOfWeek.FRIDAY, "星期五");
        enumMap.put(DayOfWeek.SATURDAY, "星期六");
        enumMap.put(DayOfWeek.SUNDAY, "星期日");
        System.out.println(enumMap);

        //TreeMap  这种类型的HashMap会根据key来进行排序
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("orange", 1);
        treeMap.put("apple", 2);
        treeMap.put("pear", 3);
        System.out.println(treeMap);//{apple=2, orange=1, pear=3}

        //Set 集合  实际上相当于只存储key、不存储value的Map。我们经常用Set用于去除重复元素。
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("a");//添加失败 因为元素重复了

        System.out.println(set.contains("a"));

        //Queue 队列
        Queue<String> queue = new LinkedList<String>();

        //添加元素 add方法会抛出错误
        try {
            queue.add("a");
            System.out.println("添加成功");
        }catch (Exception e) {
            System.out.println("添加失败");
        }

        //添加元素 offer 添加失败会返回false
        if(queue.offer("b")) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }

        //去除队首元素 remove方法 如果作用在空队列 则会抛出错误
        try {
            String s = queue.remove();
            System.out.println(queue);
            System.out.println("获取成功");
        } catch (Exception e) {
            System.out.println("获取失败");
        }

        //获取并删除队首元素  poll方法 如果获取不到会返回false
        String s1 = queue.poll();
        if(s1 != null) {
            System.out.println("获取成功");
        } else {
            System.out.println("获取失败");
        }

        //获取但不删除队首元素方法 element对应remove  peek对应poll

    }
}
