package java代码.时间代码;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class 解释 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//使用sdf设置时间的格式
        Date date = sdf.parse("2001-1-1");//将指定的日期2001-1-1转换成Date
        System.out.println(date);//检测一下date
        Calendar cal=new GregorianCalendar();//创建一个日历
        cal.setTime(date);//setTime设置时间
        cal.add(Calendar.DAY_OF_MONTH,1);//根据日历的规则，为给定的日历字段添加或减去指定的时间量。
        date=cal.getTime();//重新赋值给date
        System.out.println(date);//检查date
        /**
         * 1.1.1 YEAR
         * 这个字段的含义是年份,假如说现在是2017-1-1,那么执行:
         * System.out.println(instance.get(Calendar.YEAR));
         * 打印出来的值就为2017
         * 1.1.2 MONTH
         * 这个字段的含义是月份,假如说现在是2017-9-1,那么执行:
         * System.out.println(instance.get(Calendar.MONTH));
         * 打印出来的值就为8,值得注意的是在Calendar当中MONTH的开始月份为0
         * 1.1.3 WEEK_OF_YEAR
         * 指的是当前年的总周数当中,当前日期属于第几周
         * System.out.println("WEEK_OF_YEAR:"+instance.get(Calendar.WEEK_OF_YEAR));
         * System.out.println("一年有"+instance.getActualMaximum(Calendar.WEEK_OF_YEAR)+"个周");
         * 输出 WEEK_OF_YEAR:12
         *      一年有52个周
         * 1.1.4 DATE
         * 当前时间为多少号,例如今天为2017-3-20,那么:
         * System.out.println(instance.get(Calendar.DATE));
         * 打印的值为:
         * 20
         * 1.1.5 DAY_OF_MONTH
         * 这个月的总天数当中当前过了多少天(其实它的值和上面的DATE的值是一样的)
         * 1.1.6 DAY_OF_YEAR
         * 当年的所有天数当中,当天过了多少天
         * System.out.println("DAY_OF_YEAR:"+instance.get(Calendar.DAY_OF_YEAR));
         * System.out.println("当前年份有"+instance.getActualMaximum(Calendar.DAY_OF_YEAR)+"天");
         * 输出 DAY_OF_YEAR:79
         *      当前年份有365天
         * 1.1.7 DAY_OF_WEEK
         * 一周7天当中,当前时间是星期几(1-7),值得注意的是一周的开始是星期日,结束是星期六,
         * 如果今天是星期一,那么instance.get(Calendar.DAY_OF_WEEK)的值就应该是2
         * 1.1.8 DAY_OF_WEEK_IN_MONTH
         * 指的是当前时间是所在当前月的第几个星期,一个月的1号为第一周,8号为第二周
         * 1.1.9 WEEK_OF_MONTH
         * 同样是按当前时间在当前月的星期数,可是它的值不同于1.1.8的DAY_OF_WEEK_IN_MONTH,
         * 它计算当前星期的标准不同,例如说这个月的1号是星期3,那么是第一周,那么到了5号星期日就已经是第二周了,
         * 如果按8的DAY_OF_WEEK_IN_MONTH的计算5号才第一周
         * System.out.println("WEEK_OF_MONTH:"+instance.get(Calendar.WEEK_OF_MONTH));
         * System.out.println("当前月有"+instance.getActualMaximum(Calendar.WEEK_OF_MONTH)+"个周");
         * 输出 WEEK_OF_MONTH:4
         *      当前月有5个周(计算出来是4.4个周,它显示的为5个周)
         * 1.2.0 AM_PM
         * 用于判断当前时间是AM,还是PM,若是AM值为0,若是PM为1.
         * 1.2.1 HOUR
         * 显示当前时间的12小时制
         * 1.2.2 HOUR_OF_DAY
         * 显示当前时间的24小时制
         * 1.2.3 MINUTE
         * 显示当前时间的分钟数
         * 1.2.4 SECOND
         * 显示当前时间的秒数
         * 1.2.5 MILLISECOND
         * 显示当前时间的毫秒数
         *
         * 方法
         *
         *  ----------------------abstract void  add(int field, int amount)
         *           根据日历的规则，为给定的日历字段添加或减去指定的时间量。
         *  boolean    after(Object when)
         *           判断此 Calendar 表示的时间是否在指定 Object 表示的时间之后，返回判断结果。
         *  boolean    before(Object when)
         *           判断此 Calendar 表示的时间是否在指定 Object 表示的时间之前，返回判断结果。
         *  void   clear()
         *           将此 Calendar 的所日历字段值和时间值（从历元至现在的毫秒偏移量）设置成未定义。
         *  void   clear(int field)
         *           将此 Calendar 的给定日历字段值和时间值（从历元至现在的毫秒偏移量）设置成未定义。
         *  Object clone()
         *           创建并返回此对象的一个副本。
         *  ----------------------int    compareTo(Calendar anotherCalendar)
         *           比较两个 Calendar 对象表示的时间值（从历元至现在的毫秒偏移量）。"此函数返回值为三个,分别为-1,0,1;-1指的是当前Calendar比anotherCalendar的时间早,0指的是时间相同,1指的是比anotherCalendar时间晚"
         *  ----------------------boolean    equals(Object obj)
         *           将此 Calendar 与指定 Object 比较。
         *  ----------------------int    get(int field)
         *           返回给定日历字段的值。
         *  ----------------------int    getActualMaximum(int field)
         *           给定此 Calendar 的时间值，返回指定日历字段可能拥有的最大值。
         *  ----------------------int    getActualMinimum(int field)
         *           给定此 Calendar 的时间值，返回指定日历字段可能拥有的最小值。
         * static Locale[] getAvailableLocales()
         *           返回所有语言环境的数组，此类的 getInstance 方法可以为其返回本地化的实例。
         *  String getDisplayName(int field, int style, Locale locale)
         *           返回给定 style 和 locale 下的日历 field 值的字符串表示形式。
         *  Map<String,Integer>    getDisplayNames(int field, int style, Locale locale)
         *           返回给定 style 和 locale 下包含日历 field 所有名称的 Map 及其相应字段值。
         *  int    getFirstDayOfWeek()
         *           获取一星期的第一天；例如，在美国，这一天是 SUNDAY，而在法国，这一天是 MONDAY。
         * abstract  int   getGreatestMinimum(int field)
         *           返回此 Calendar 实例给定日历字段的最高的最小值。
         * ----------------------static Calendar getInstance()
         *           使用默认时区和语言环境获得一个日历。
         * static Calendar getInstance(Locale aLocale)
         *           使用默认时区和指定语言环境获得一个日历。
         * static Calendar getInstance(TimeZone zone)
         *           使用指定时区和默认语言环境获得一个日历。
         * static Calendar getInstance(TimeZone zone, Locale aLocale)
         *           使用指定时区和语言环境获得一个日历。
         * abstract  int   getLeastMaximum(int field)
         *           返回此 Calendar 实例给定日历字段的最低的最大值。
         * ----------------------abstract  int   getMaximum(int field)
         *           返回此 Calendar 实例给定日历字段的最大值。
         *  int    getMinimalDaysInFirstWeek()
         *           获取一年中第一个星期所需的最少天数，例如，如果定义第一个星期包含一年第一个月的第一天，则此方法将返回 1。
         * abstract  int   getMinimum(int field)
         *           返回此 Calendar 实例给定日历字段的最小值。
         *  ----------------------Date   getTime()
         *           返回一个表示此 Calendar 时间值（从历元至现在的毫秒偏移量）的 Date 对象。
         *  long   getTimeInMillis()
         *           返回此 Calendar 的时间值，以毫秒为单位。
         *  TimeZone   getTimeZone()
         *           获得时区。
         *  int    hashCode()
         *           返回该此日历的哈希码。
         *  boolean    isLenient()
         *           判断日期/时间的解释是否为宽松的。
         *  boolean    isSet(int field)
         *           确定给定日历字段是否已经设置了一个值，其中包括因为调用 get 方法触发内部字段计算而导致已经设置该值的情况。
         * abstract  void  roll(int field, boolean up)
         *           在给定的时间字段上添加或减去（上/下）单个时间单元，不更改更大的字段。
         *  void   roll(int field, int amount)
         *           向指定日历字段添加指定（有符号的）时间量，不更改更大的字段。
         *  void   set(int field, int value)
         *           将给定的日历字段设置为给定值。
         *  void   set(int year, int month, int date)
         *           设置日历字段 YEAR、MONTH 和 DAY_OF_MONTH 的值。
         *  void   set(int year, int month, int date, int hourOfDay, int minute)
         *           设置日历字段 YEAR、MONTH、DAY_OF_MONTH、HOUR_OF_DAY 和 MINUTE 的值。
         *  void   set(int year, int month, int date, int hourOfDay, int minute, int second)
         *           设置字段 YEAR、MONTH、DAY_OF_MONTH、HOUR、MINUTE 和 SECOND 的值。
         *  void   setFirstDayOfWeek(int value)
         *           设置一星期的第一天是哪一天；例如，在美国，这一天是 SUNDAY，而在法国，这一天是 MONDAY。
         *  void   setLenient(boolean lenient)
         *           指定日期/时间解释是否是宽松的。
         *  void   setMinimalDaysInFirstWeek(int value)
         *           设置一年中第一个星期所需的最少天数，例如，如果定义第一个星期包含一年第一个月的第一天，则使用值 1 调用此方法。
         *  ----------------------void   setTime(Date date)
         *           使用给定的 Date 设置此 Calendar 的时间。
         *  void   setTimeInMillis(long millis)
         *           用给定的 long 值设置此 Calendar 的当前时间值。
         *  void   setTimeZone(TimeZone value)
         *           使用给定的时区值来设置时区。
         *  String toString()
         *           返回此日历的字符串表示形式。
         */
    }
}
