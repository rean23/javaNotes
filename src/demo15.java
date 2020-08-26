import java.security.SecureRandom;
import java.util.Random;
import java.math.BigDecimal;

public class demo15 {
    public static void main(String[] args) {
        int a = 100;
        Integer n = Integer.valueOf(a);
        int x = n.intValue();

        System.out.println(x);
        System.out.println(n);

        Integer n1 = Integer.valueOf(10000);
        Integer n2 = Integer.valueOf(10000);
        System.out.println(n1.equals(n2));


        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            random.setSeed(100);
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + random.nextInt(100) + ", ");
            }
            System.out.println("");
        }

        SecureRandom random = new SecureRandom();
        random.nextInt(100);

        BigDecimal d3 = new BigDecimal("1234500");
        BigDecimal d4 = d3.stripTrailingZeros();//去除末尾的0
        System.out.println(d3.scale()); // 0 //小数位数
        System.out.println(d4.scale()); // -2 复数表示是个整数，2则是表示末尾两个0

    }
}
