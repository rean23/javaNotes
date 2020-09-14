import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

//时间
public class demo23 {
    public static void main(String[] args) {
        //Date
        Date date = new Date();
        System.out.println(date.getYear() + 1900); // 必须加上1900
        System.out.println(date.getMonth() + 1); // 0~11，必须加上1
        System.out.println(date.getDate()); // 1~31，不能加1
        // 转换为String:
        System.out.println(date.toString());
        // 转换为GMT时区:
        System.out.println(date.toGMTString());
        // 转换为本地时区:
        System.out.println(date.toLocaleString());

        /**
         * 预定义字符串：
         * yyyy：年
         * MM：月
         * dd: 日
         * HH: 小时
         * mm: 分钟
         * ss: 秒
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
        /**
         * Date对象有几个严重的问题：它不能转换时区，除了toGMTString()可以按GMT+0:00输出外，
         * Date总是以当前计算机系统的默认时区为基础进行输出。此外，我们也很难对日期和时间进行加减，
         * 计算两个日期相差多少天，计算某个月第一个星期一的日期等。
         */


        // Calendar 自定义时间
        Calendar c = Calendar.getInstance();
        // 清除所有:
        c.clear();
        // 设置为北京时区:
        c.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        // 设置年月日时分秒:
        c.set(2019, 10 /* 11月 */, 20, 8, 15, 0);
        // 显示时间格式
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置时区
        sdf1.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println(sdf1.format(c.getTime()));
        // 2019-11-19 19:15:00

        //执行代码的时候会有一点时间差
        LocalDate d = LocalDate.now();
        LocalTime t = LocalTime.now();
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(d);
        System.out.println(t);
        System.out.println(dt);

        System.out.println(dt.toLocalDate());
        System.out.println(dt.toLocalTime());

        LocalDate d2 = LocalDate.of(2020, 8, 24);
        LocalTime t2 = LocalTime.of(9, 16, 23);
        LocalDateTime dt2 = LocalDateTime.of(2020, 8, 24, 9, 16, 23);
        LocalDateTime dt3 = LocalDateTime.of(d2, t2);

        System.out.println(dt2);
        System.out.println(dt3);

        //解析时间
        LocalDateTime dt4 = LocalDateTime.parse("2020-08-24T09:16:23");
        LocalDate d3 = LocalDate.parse("2020-08-24");
        LocalTime t3 = LocalTime.parse("09:16:23");

        //时间格式化
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(dt4));
        //System.out.println(dtf.format(d3));
        //System.out.println(dtf.format(t3));


        LocalDateTime dt5 = LocalDateTime.parse("2019/11/30 15:16:17", dtf);
        System.out.println(dt5);


        //ZonedDateTime 获取时区时间
        ZonedDateTime zdt = ZonedDateTime.now();
        ZonedDateTime znt = ZonedDateTime.now(ZoneId.of("America/New_York"));

        System.out.println(zdt);//2020-08-24T10:04:54.351+08:00[Asia/Shanghai]
        System.out.println(znt);//2020-08-23T22:04:54.354-04:00[America/New_York]

        LocalDateTime ldt = LocalDateTime.of(2020, 8, 24, 13, 16, 37);
        ZonedDateTime zbj = ldt.atZone(ZoneId.systemDefault());
        ZonedDateTime zny = ldt.atZone(ZoneId.of("America/New_York"));

        System.out.println(dtf.format(zny.toLocalDateTime()));//输出格式化日期
        System.out.println(zbj);
        System.out.println(zny);
    }
}
