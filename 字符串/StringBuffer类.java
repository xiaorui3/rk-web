package java代码.字符串;

public class StringBuffer类 {
/**
 * 追加字符串
 *     StringBuffer 类的 append() 方法用于向原有 StringBuffer 对象中追加字符串。该方法的语法格式如下：
 *     StringBuffer 对象.append(String str)
 *
 *     该方法的作用是追加内容到当前 StringBuffer 对象的末尾，类似于字符串的连接。调用该方法以后，StringBuffer 对象的内容也发生了改变，例如：
 *     StringBuffer buffer = new StringBuffer("hello,");    // 创建一个 StringBuffer 对象
 *     String str = "World!";
 * buffer.append(str);    // 向 StringBuffer 对象追加 str 字符串
 * System.out.println(buffer.substring(0));    // 输出：Hello,World!
 *     例 1
 *     每个新学期开始，学校都会针对本学期课程列出必修课程。编写一个 Java 程序，要求用户向控制台循环录入五门必修课程名称，并将这五个名称进行连接，最后输出连接后的字符串。代码如下：
 *             import java.util.Scanner;
 *     public class Testl9 {
 *         public static void main(String[] args) {
 *             StringBuffer sys = new StringBuffer("校内课程管理");
 *             System.out.println("欢迎进入《"+sys+"》系统");
 *             // 声明课程名称字符串
 *             StringBuffer courseName = new StringBuffer();
 *             System.out.println("请录入本期的五门必修课名称：");
 *             Scanner input = new Scanner(System.in);
 *             // 循环接收控制台输入的字符串
 *             String name = "";
 *             for (int i = 0;i < 5;i++) {
 *                 name = input.next();
 *                 courseName.append(name+"\t");
 *                 if(i == 4) {
 *                     System.out.println("录入完毕!");
 *                 }
 *             }
 *             System.out.println("本学期的必修课程有：\n"+courseName);
 *         }
 *
 *         在该程序中，首先声明一个空的 StringBuffer 对象，然后声明并初始化 courseName 变量，该变量用于存储用户从控制台输入的课程名称，接着使用 for 循环语句来循环接收用户输入数据。在循环体中，调用 StringBuffer 对象的 append() 方法对用户输入的字符串进行追加，当用户录完五门课程的名称后，程序将输出“录入完毕！”的提示信息。最后输出 String-Buffer 对象字符串。
 *
 *         运行程序，执行结果如下所示：
 *         欢迎进入《校内课程管理》系统
 *         请录入本期的五门必修课名称：
 *         Java语言基础
 *                 SQL查询数据库
 *         模拟电路
 *                 Java面向对象编程
 *         体育
 *         录入完毕!
 *         本学期的必修课程有：Java语言基础  SQL查询数据库  模拟电路  Java面向对象编程  体育
 *                 替换字符
 *         StringBuffer 类的 setCharAt() 方法用于在字符串的指定索引位置替换一个字符。该方法的语法格式如下：
 *         StringBuffer 对象.setCharAt(int index, char ch);
 *
 *         该方法的作用是修改对象中索引值为 index 位置的字符为新的字符 ch，例如：
 *         StringBuffer sb = new StringBuffer("hello");
 * sb.setCharAt(1,'E');
 * System.out.println(sb);    // 输出：hEllo
 * sb.setCharAt(0,'H');
 * System.out.println(sb);    // 输出：HEllo
 * sb.setCharAt(2,'p');
 * System.out.println(sb);    // 输出：HEplo
 *         反转字符串
 *         StringBuffer 类中的 reverse() 方法用于将字符串序列用其反转的形式取代。该方法的语法格式如下：
 *         StringBuffer 对象.reverse();
 *
 *         使用 StringBuffer 类中的 reverse() 方法对字符串进行反转的示例如下：
 *         StringBuffer sb = new StringBuffer("java");
 * sb.reverse();
 * System.out.println(sb);    // 输出：avaj
 *         删除字符串
 *         StringBuffer 类提供了 deleteCharAt() 和 delete() 两个删除字符串的方法，下面详细介绍。
 *                 1. deleteCharAt() 方法
 *         deleteCharAt() 方法用于移除序列中指定位置的字符，该方法的语法格式如下：
 *         StringBuffer 对象.deleteCharAt(int index);
 *         deleteCharAt() 方法的作用是删除指定位置的字符，然后将剩余的内容形成一个新的字符串。例如：
 *         StringBuffer sb = new StringBuffer("She");
 * sb.deleteCharAt(2);
 * System.out.println(sb);    // 输出：Sh
 *
 *         执行该段代码，将字符串 sb 中索引值为 2 的字符删除，剩余的内容组成一个新的字符串，因此对象 sb 的值为 Sh。
 *                 2. delete() 方法
 *         delete() 方法用于移除序列中子字符串的字符，该方法的语法格式如下：
 *         StringBuffer 对象.delete(int start,int end);
 *         其中，start 表示要删除字符的起始索引值（包括索引值所对应的字符），end 表示要删除字符串的结束索引值（不包括索引值所对应的字符）。该方法的作用是删除指定区域以内的所有字符，例如：
 *         StringBuffer sb = new StringBuffer("hello jack");
 * sb.delete(2,5);
 * System.out.println(sb);    // 输出：he jack
 * sb.delete(2,5);
 * System.out.println(sb);    // 输出：heck
 */
}
