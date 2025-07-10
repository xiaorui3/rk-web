package java代码.时间代码;

import java.util.Calendar;

public class Calendar类 {
    /**
     *  方法	描述
     *     void add(int field, int amount)	根据日历的规则，为给定的日历字段 field 添加或减去指定的时间量 amount
     *     boolean after(Object when)	判断此 Calendar 表示的时间是否在指定时间 when 之后，并返回判断结果
     *     boolean before(Object when)	判断此 Calendar 表示的时间是否在指定时间 when 之前，并返回判断结果
     *     void clear()	清空 Calendar 中的日期时间值
     *     int compareTo(Calendar anotherCalendar)	比较两个 Calendar 对象表示的时间值（从格林威治时间 1970 年 01 月 01 日
     * 00 时 00 分 00 秒至现在的毫秒偏移量），大则返回 1，小则返回 -1，相等返回 0
     *     int get(int field)	返回指定日历字段的值
     *     int getActualMaximum(int field)	返回指定日历字段可能拥有的最大值
     *     int getActualMinimum(int field)	返回指定日历字段可能拥有的最小值
     *     int getFirstDayOfWeek()	获取一星期的第一天。根据不同的国家地区，返回不同的值
     *
     * ****************static Calendar getInstance()	使用默认时区和语言坏境获得一个日历********************
     *
     *     static Calendar getInstance(TimeZone zone)	使用指定时区和默认语言环境获得一个日历
     *     static Calendar getInstance(TimeZone zone,
     *                                 Locale aLocale)	使用指定时区和语言环境获得一个日历
     *     Date getTime()	返回一个表示此 Calendar 时间值（从格林威治时间 1970 年 01 月 01 日 00 时
     * 00 分 00 秒至现在的毫秒偏移量）的 Date 对象
     *     long getTimeInMillis()	返回此 Calendar 的时间值，以毫秒为单位
     *     void set(int field, int value)	为指定的日历字段设置给定值
     *     void set(int year, int month, int date)	设置日历字段 YEAR、MONTH 和 DAY_OF_MONTH 的值
     *     void set(int year, int month, int date, int hourOfDay,
     *              int minute, int second)	设置字段 YEAR、MONTH、DAY_OF_MONTH、HOUR、 MINUTE 和 SECOND 的值
     *     void setFirstDayOfWeek(int value)	设置一星期的第一天是哪一天
     *     void setTimeInMillis(long millis)	用给定的 long 值设置此 Calendar 的当前时间值
     *     Calendar 对象可以调用 set() 方法将日历翻到任何一个时间，当参数 year 取负数时表示公元前。Calendar 对象调用 get() 方法可以获取有关年、月、日等时间信息，参数 field 的有效值由 Calendar 静态常量指定。
     *
     *     Calendar 类中定义了许多常量，分别表示不同的意义。
     *     Calendar.YEAR：年份。
     *     Calendar.MONTH：月份。
     *     Calendar.DATE：日期。
     *     Calendar.DAY_OF_MONTH：日期，和上面的字段意义完全相同。
     *     Calendar.HOUR：12小时制的小时。
     *     Calendar.HOUR_OF_DAY：24 小时制的小时。
     *     Calendar.MINUTE：分钟。
     *     Calendar.SECOND：秒。
     *     Calendar.DAY_OF_WEEK：星期几。
     * @param args
     */


/*    例如，要获取当前月份可用如下代码：
    int month = Calendar.getInstance().get(Calendar.MONTH);*/

    /*详细看解释txt*/
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.JUNE, 1); // 实际的calendar对象所表示的日期为2016年6月1日
        // 判断2016年6月1日为一周中的第几天
        int index = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        char[] title = { '日', '一', '二', '三', '四', '五', '六' }; // 存放曰历的头部
        int daysArray[][] = new int[6][7];// 存放日历的数据
        int daysInMonth = 31; // 该月的天数
        int day = 1; // 自动增长
        for (int i = index; i < 7; i++) {
            // 填充第一周的日期数据，即日历中的第一行
            daysArray[0][i] = day++;
        }
        for (int i = 1; i < 6; i++) {
            // 填充其他周的日历数据，控制行
            for (int j = 0; j < 7; j++) {
                // 如果当前day表示的是本月最后一天，则停止向数组中继续赋值
                if (day > daysInMonth) {
                    i = 6;
                    break;
                }
                daysArray[i][j] = day++;
            }
        }
        System.out.println("------------------2016 年 6 月--------------------\n");
        for (int i = 0; i < title.length; i++) {
            System.out.print(title[i] + "\t");
        }
        System.out.print("\n");
        // 输出二元数组daysArray中的元素
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (daysArray[i][j] == 0) {
                    if (i != 0) {
                        // 如果到月末，则完成显示日历的任务，停止该方法的执行
                        return;
                    }
                    System.out.print("\t");
                    continue;
                }
                System.out.print(daysArray[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }
}
