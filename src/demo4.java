//数组
public class demo4 {
    public static void main(String[] args) {
        //创建一个数组  容量为10个元素
        /**
         * Java的数组有几个特点：
         * 数组所有元素初始化为默认值，整型都是0，浮点型是0.0，布尔型是false；
         * 数组一旦创建后，大小就不可改变。
         */
        int[] arr = new int[10];
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};//定义初始化元素
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};//上一行的简写

        //数组是引用类型
        int[] array = {1, 2, 3, 4, 5};
        array = new int[]{7, 8, 9};//这里实际上改变的是array这个变量的指向 之前的数组依旧存在  只是不能在通过array变量引用了

        System.out.println(array.length);

        //字符串数组
        //如果数组元素不是基本类型，而是一个引用类型，比如字符串数组，里面的元素都分别指向不同的字符串对象
        String[] arr3 = {"Beckham", "Ronaldo", "Rean"};
        arr3[2] = "Lingard";//这里修改元素也只是改变了指向而已

        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }
    }
}
