import java.util.Arrays;

public class demo7 {
    public static void main(String[] args) {
        int[] arr = {28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        //打印数组 非循环
        System.out.println(Arrays.toString(arr));

        //冒泡排序
        System.out.println("排序前：" + Arrays.toString(arr));
        int length = arr.length;
        /*for (int i = 0; i <= length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        System.out.println("排序后：" + Arrays.toString(arr));*/

        //标准库排序
        Arrays.sort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));

        //二维数组
        int[][] arr1 = {
                {10, 5, 1, 6},
                {11, 3, 2, 9},
                {22, 13, 45, 6},
        };
        System.out.println(Arrays.deepToString(arr1));//打印二维数组
    }
}
