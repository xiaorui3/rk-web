package java代码.正则表达式;

public class 代码 {
/**
 * Pattern 对象是正则表达式编译后在内存中的表示形式，因此，正则表达式字符串必须先被编译为 Pattern 对象，然后再利用该 Pattern 对象创建对应的 Matcher 对象。执行匹配所涉及的状态保留在 Matcher 对象中，多个 Matcher 对象可共享同一个 Pattern 对象。
 *
 *     因此，典型的调用顺序如下：
 *     // 将一个字符串编译成 Pattern 对象
 *     Pattern p = Pattern.compile("a*b");
 *     // 使用 Pattern 对象创建 Matcher 对象
 *     Matcher m = p.matcher("aaaaab");
 *     boolean b = m.matches(); // 返回 true
 *
 *     上面定义的 Pattern 对象可以多次重复使用。如果某个正则表达式仅需一次使用，则可直接使用 Pattern 类的静态 matches() 方法，此方法自动把指定字符串编译成匿名的 Pattern 对象，并执行匹配，如下所示。
 *     boolean b = Pattern.matches ("a*b","aaaaab");    // 返回 true
 *
 *     上面语句等效于前面的三条语句。但采用这种语句每次都需要重新编译新的 Pattern 对象，不能重复利用已编译的 Pattern 对象，所以效率不高。Pattern 是不可变类，可供多个并发线程安全使用。
 *
 *     Matcher 类提供了几个常用方法，如表 1 所示。
 *     表 1 Matcher 类的几个常用方法
 *     名称	说明
 *     find()	返回目标字符串中是否包含与 Pattern 匹配的子串
 *     group()	返回上一次与 Pattern 匹配的子串
 *     start()	返回上一次与 Pattern 匹配的子串在目标字符串中的开始位置
 *     end()	返回上一次与 Pattern 匹配的子串在目标字符串中的结束位置加 1
 *     lookingAt()	返回目标字符串前面部分与 Pattern 是否匹配
 *     matches()	返回整个目标字符串与 Pattern 是否匹配
 *     reset()	将现有的 Matcher 对象应用于一个新的字符序列。
 *     在 Pattern、Matcher 类的介绍中经常会看到一个 CharSequence 接口，该接口代表一个字符序列，其中 CharBuffer、String、StringBuffer、StringBuilder 都是它的实现类。简单地说，CharSequence 代表一个各种表示形式的字符串。
 *
 *     通过 Matcher 类的 find() 和 group() 方法可以从目标字符串中依次取出特定子串（匹配正则表达式的子串），例如互联网的网络爬虫，它们可以自动从网页中识别出所有的电话号码。下面程序示范了如何从大段的字符串中找出电话号码。
 *     public class FindGroup {
 *         public static void main(String[] args) {
 *             // 使用字符串模拟从网络上得到的网页源码
 *             String str = "我想找一套适合自己的JAVA教程，尽快联系我13500006666" + "交朋友，电话号码是13611125565" + "出售二手电脑，联系方式15899903312";
 *             // 创建一个Pattern对象，并用它建立一个Matcher对象
 *             // 该正则表达式只抓取13X和15X段的手机号
 *             // 实际要抓取哪些电话号码，只要修改正则表达式即可
 *             Matcher m = Pattern.compile("((13\\d)|(15\\d))\\d{8}").matcher(str);
 *             // 将所有符合正则表达式的子串（电话号码）全部输出
 *             while (m.find()) {
 *                 System.out.println(m.group());
 *             }
 *         }
 *     }
 *     运行上面程序，看到如下运行结果：
 *             13500006666
 *             13611125565
 *             15899903312
 *
 *     从上面运行结果可以看出，find() 方法依次查找字符串中与 Pattern 匹配的子串，一旦找到对应的子串，下次调用 find() 方法时将接着向下查找。
 *
 *     提示：通过程序运行结果可以看出，使用正则表达式可以提取网页上的电话号码，也可以提取邮件地址等信息。如果程序再进一步，可以从网页上提取超链接信息，再根据超链接打开其他网页，然后在其他网页上重复这个过程就可以实现简单的网络爬虫了。
 *
 *     find() 方法还可以传入一个 int 类型的参数，带 int 参数的 find() 方法将从该 int 索引处向下搜索。start() 和 end() 方法主要用于确定子串在目标字符串中的位置，如下程序所示。
 *     public class StartEnd {
 *         public static void main(String[] args) {
 *             // 创建一个Pattern对象，并用它建立一个Matcher对象
 *             String regStr = "Java is very easy!";
 *             System.out.println("目标字符串是：" + regStr);
 *             Matcher m = Pattern.compile("\\w+").matcher(regStr);
 *             while (m.find()) {
 *                 System.out.println(m.group() + "子串的起始位置：" + m.start() + "，其结束位置：" + m.end());
 *             }
 *         }
 *     }
 *     上面程序使用 find()、group() 方法逐项取出目标字符串中与指定正则表达式匹配的子串，并使用 start()、end() 方法返回子串在目标字符串中的位置。运行上面程序，看到如下运行结果：
 *     目标字符串是：Java is very easy!
 *     Java子串的起始位置：0，其结束位置：4
 *     is子串的起始位置：5，其结束位置：7
 *     very子串的起始位置：8，其结束位置：12
 *     easy子串的起始位置：13，其结束位置：17
 *
 *     matches() 和 lookingAt() 方法有点相似，只是 matches() 方法要求整个字符串和 Pattern 完全匹配时才返回 true，而 lookingAt() 只要字符串以 Pattern 开头就会返回 true。reset() 方法可将现有的 Matcher 对象应用于新的字符序列。看如下例子程序。
 *     public class MatchesTest {
 *         public static void main(String[] args) {
 *             String[] mails = { "kongyeeku@163.com", "kongyeeku@gmail.com", "ligang@crazyit.org", "wawa@abc.xx" };
 *             String mailRegEx = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
 *             Pattern mailPattern = Pattern.compile(mailRegEx);
 *             Matcher matcher = null;
 *             for (String mail : mails) {
 *                 if (matcher == null) {
 *                     matcher = mailPattern.matcher(mail);
 *                 } else {
 *                     matcher.reset(mail);
 *                 }
 *                 String result = mail + (matcher.matches() ? "是" : "不是") + "一个有效的邮件地址！";
 *                 System.out.println(result);
 *             }
 *         }
 *     }
 *     上面程序创建了一个邮件地址的 Pattern，接着用这个 Pattern 与多个邮件地址进行匹配。当程序中的 Matcher 为 null 时，程序调用 matcher() 方法来创建一个 Matcher 对象，一旦 Matcher 对象被创建，程序就调用 Matcher 的 reset() 方法将该 Matcher 应用于新的字符序列。
 *
 *     从某个角度来看，Matcher 的 matches()、lookingAt() 和 String 类的 equals() 有点相似。区别是 String 类的 equals() 都是与字符串进行比较，而 Matcher 的 matches() 和 lookingAt() 则是与正则表达式进行匹配。
 *
 *     事实上，String 类里也提供了 matches() 方法，该方法返回该字符串是否匹配指定的正则表达式。例如：
 *             "kongyeeku@163.com".matches("\\w{3,20}@\\w+\\.(com|org|cn|net|gov)"); // 返回 true
 *
 *
 *     除此之外，还可以利用正则表达式对目标字符串进行分割、查找、替换等操作，看如下例子程序。
 *     public class ReplaceTest {
 *         public static void main(String[] args) {
 *             String[] msgs = { "Java has regular expressions in 1.4", "regular expressions now expressing in Java",
 *                     "Java represses oracular expressions" };
 *             Pattern p = Pattern.compile("re\\w*");
 *             Matcher matcher = null;
 *             for (int i = 0; i < msgs.length; i++) {
 *                 if (matcher == null) {
 *                     matcher = p.matcher(msgs[i]);
 *                 } else {
 *                     matcher.reset(msgs[i]);
 *                 }
 *                 System.out.println(matcher.replaceAll("哈哈:)"));
 *             }
 *         }
 *     }
 *     上面程序使用了 Matcher 类提供的 replaceAll() 把字符串中所有与正则表达式匹配的子串替换成“哈哈:)”，实际上，Matcher 类还提供了一个 replaceFirst()，该方法只替换第一个匹配的子串。运行上面程序，会看到字符串中所有以“re”开头的单词都会被替换成“哈哈:)”。
 *
 *     实际上，String 类中也提供了 replaceAll()、replaceFirst()、split() 等方法。下面的例子程序直接使用 String 类提供的正则表达式功能来进行替换和分割。
 *     public class StringReg {
 *         public static void main(String[] args) {
 *             String[] msgs = { "Java has regular expressions in 1.4", "regular expressions now expressing in Java",
 *                     "Java represses oracular expressions" };
 *             for (String msg : msgs) {
 *                 System.out.println(msg.replaceFirst("re\\w*", "哈哈:)"));
 *                 System.out.println(Arrays.toString(msg.split(" ")));
 *             }
 *         }
 *     }
 *     上面程序只使用 String 类的 replaceFirst() 和 split() 方法对目标字符串进行了一次替换和分割。运行上面程序，会看到如下所示的输出结果。
 *     Java has 哈哈:) expressions in 1.4
 *             [Java, has, regular, expressions, in, 1.4]
 *     哈哈:) expressions now expressing in Java
 * [regular, expressions, now, expressing, in, Java]
 *     Java 哈哈:) oracular expressions
 * [Java, represses, oracular, expressions]
 *
 *     正则表达式是一个功能非常灵活的文本处理工具，增加了正则表达式支持后的 Java，可以不再使用 StringTokenizer 类（也是一个处理字符串的工具，但功能远不如正则表达式强大）即可进行复杂的字符串处理。
 */
}
