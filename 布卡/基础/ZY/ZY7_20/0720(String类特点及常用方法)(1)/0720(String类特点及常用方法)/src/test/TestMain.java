package test;

import java.lang.reflect.Field;

public class TestMain {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        String s1 = "zzt";
//        String s2 = "zzt";
//        //创建了几个String类型的对象?	放哪儿了?
//        //          1个          字符串常量区


//        String s3 = new String("zzt");
//        //创建了几个String类型的对象?	放哪儿了?
//        //          "zzt"字符串常量区中
//        //          new 申请的堆内存空间

//        String s4 = new String();
//        //创建了几个String类型的对象?	放哪儿了?
//        //  2个          ""


//        String s5 = "";//常量
//        String s6 = new String();//空数组
//        String s7 = new String("");//value hash


        //笔试题==和equals
//        String s1 = "zzt";
//        String s2 = "zzt";
//        String s3 = new String("zzt");
//        String s4 = new String("zzt");
//        System.out.println(s1==s2);//true
//        System.out.println(s2==s3);//false
//        System.out.println(s3==s4);//false
//        System.out.println(s1.equals(s2));//true
//        System.out.println(s2.equals(s3));//true
//        System.out.println(s3.equals(s4));//true
//        //equals方法
//        //Object类中的方法
//
//        TestMain tm = new TestMain();
//        tm.equals("");
//        //tm==""


//        String s = new String("zzt");
//        s.equals(tm);
//        //s ss地址一样


//        String s8 = "zzt";
//        String s9 = "123";
//        String s10 = s8 + s9;   //运算符号重载
//        //产生了几个字符串对象？
//        //      zzt 123
//        //      +拼接  产生一个StringBuilder对象
//        //          append(zzt) append(123) zzt123----new String(sb)
//        System.out.println(s10);
//        //  第一个方式   debug       断点
//        //      带弯折的蓝色按钮---->向下走一行
//        //      蓝色向下的按钮------>进入调用的方法
//        //      红色向下的按钮------>看似没有方法，实际有方法
//        //  找.class文件   利用javap反编译      javac java javadoc javap


//        String s11 = "zzt"+"123";
//        //"zzt" "123"       +拼接  StringBuilder   append  append
//        //                  StringBuilder----->new String("zzt123")
//        System.out.println(s11);



        //==============================================================

        //String类中常用的方法

        //1.不是String类自己的方法，从某个父类(父接口)继承(实现)过来的
        //  equals---->Object
        //      public boolean equals(Object obj){
        //          return (this == obj);
        //      }
        //      String类中的equals方法重写了----->比字面值
        //      public boolean equals(Object obj){
        //          if(this==obj){
        //              return true;
        //          }
        //          if(obj instanceof String){
        //              字面值     while
        //          }
        //          return false;
        //      }

//        String s1 = "abc";
//        String s2 = "ABC";
//        System.out.println(s1.equals(s2));//
//        System.out.println(s1.equalsIgnoreCase(s2));//true


        //2.hashCode-----Object
        //      Object默认的方法
        //      public native int hashCode();
        //          底层调用了一个C++写的本地方法
        //          拿到对象的内存地址---经过一个hash算法---得到一个int类型的数

        //      HashMap 底层的比较原则     hashCode和equals
        //                               int一致    true

//        TestMain tm = new TestMain();
//        int hash = tm.hashCode();
//        System.out.println(hash);//22307196

//        String s1 = "abc";            //97   3105

        //h = 97          h = (97*31+98)*31+99
//        Class clazz = s1.getClass();
//        Field field = clazz.getDeclaredField("hash");
//        field.setAccessible(true);
//        int hash = (int)field.get(s1);
//        System.out.println(hash);

//        int hash = s1.hashCode();
        //System.out.println(hash);//121140


        //3.compareTo           String implements Comparable<String>
        //      int = compareTo(String anotherStr)
        //      Serializable    可以被序列化  可以被反序列
        //      Comparable      可比较的
        //      CharSequence    字符序列
//            StringBuilder sb = new StringBuilder();
//            sb.append("zzt");
//            sb.append("123");
//            new String(sb);

//        String s1 = "abc";      //[a,b,c]
//        String s2 = "cbddefg";  //[a,b,d,d,e,f,g]
//        System.out.println(s1==s2); //true
//        System.out.println(s1.equals(s2));  //true
//        int value = s1.compareTo(s2);
//        System.out.println(value);  //? 0           a-c -2
        //      找长度最短的值----3
        //      循环3次    c-d     如果int结果是负数，证明s1顺序靠前，字典索引顺序
        //      TreeMap(基于compareTo的比较规则)

//        String s1 = "abc";
//        String s2 = "ABC";
//        System.out.println(s1.compareTo(s2));   //97-65
//        System.out.println(s1.compareToIgnoreCase(s2));     //0


        //4.    toString()
        //      Object类里面的
        //      public String toString() {
        //          return getClass().getName() + "@" + Integer.toHexString(hashCode());
        //      }
//        TestMain tm = new TestMain();//Person name age sex
//        System.out.println(tm);     //test.TestMain @ 154617c
//
//        String s = "zzt";
//        s.toString();
//        System.out.println(s);      //zzt

        //======================================================================

        //  方法名字，方法的参数，方法的返回值，方法的作用，最好知道源码大概的执行原理(过程)

        //5.    char = charAt(int index)
        //      给定一个index索引位置，返回这个位置对应的那个char字

//        String s = "我bcd";
//        char a = s.charAt(0);//'a'
//        System.out.println(a);

        //6.    int code = codePointAt(int index)

        //7.    int = length();
        //          int = array.length
        //          int = str.length();
        //          int = box.size();

        //8.    String = concat(String str)     拼接
//        String s1 = "abc";      //abc???    不可变特性
//        s1 = s1.concat("123");   //拼接    新的String对象，6个
//        System.out.println(s1);//???    abc123
        //concat    +       谁好？
        //String s1 = "a"+"b"+"c"+"d";  //a b c d ab abc abcd   常量优化"abcd"
        //  s5=s1+s2+s3+s4  StringBuilder   append("a") append("b")     newString
        //String s2 = "a".concat("b").concat("c").concat("d");


        //9.    byte[] = getBytes();
//        String s = "abcd";
//        byte[] b = s.getBytes();        //[97,98,99,100]
//        for(byte x : b){
//            System.out.println(x);
//        }
//        String s1 = new String(b);
//        System.out.println(s1);

        //10.      char[] = toCharArray();
//        String s = "abcd";
//        char[] c = s.toCharArray();
//        for(char x : c){
//            System.out.println(x);
//        }
//        String s1 = new String(c);
//        System.out.println(s1);

        //11.       int = indexOf(int code / String str)
        //11.       int = indexOf(int code / String str , int fromIndex)
//        String s = "zzt is very very good!";
//        int index = s.indexOf("v",8); //2     -1
//        //找寻e字母在s字符串中第一次出现的索引位置
//        System.out.println(index);//    总长度中的位置

        //12.       int = lastIndexOf(int code /String , int fromIndex);
//        String s = "zzt is very very good!";
//        int index = s.lastIndexOf("v");
//        System.out.println(index);


        //13.       replace替换   replaceFirst   replaceAll
        //          String = replace(char old,char new) ;
        //          String = replace(CharSequence old,CharSequence new) ;
        //          String = replaceAll(String regex,String replaceElement) ;
        //          String = replaceFirst(String regex,String replaceElement)
//        String s = "zzt is very very good!";
////        StringBuilder sb = new StringBuilder("zz");
////        s.replace('z','A');
////        s = s.replace("very",sb);
////        s = s.replaceFirst("z","A");
//        s = s.replaceAll("z","A");
//        System.out.println(s);


        //14.       String[] = split(String regex , [int limit])
//        String s = "a-b-c-d";
//        String[] value = s.split("-",2);  //{"a-b-c-d"}
//        for(String v : value){
//            System.out.println(v);
//        }


        //15.       String = substring(int begin[,int end])
//        String s = "zzt is very good";
//        String value = s.substring(7);      // [begin,end)
//        System.out.println(value);

        //16.       String = toUpperCase();     全部转化成大写字母
        //17.       String = toLowerCase();     全部转化成小写字母
//        String s = "zzt is very good";
//        s = s.toUpperCase();
//        System.out.println(s);
//        s = s.toLowerCase();
//        System.out.println(s);


        //18.       String = trim()     去掉字符串的头尾空格
//        String s = "    zzt is very good         ";
//        s = s.trim();
//        System.out.println(s);


        //19.       boolean = startsWith(String str)
        //20.       boolean = endsWith(String str)

//        String s = "Java is good";
//        boolean b = s.startsWith("Java is good zzt");
//        boolean b1 = s.endsWith("good");
//        System.out.println(b1);

        //21.       boolean = contains(CharSequence c)
//        String s = "zzt is very good";
//        boolean b = s.contains("zig");
//        System.out.println(b);

        //22.       boolean = isEmpty();
        String s = "";
        boolean b = s.isEmpty();
        System.out.println(b);

        //      判断空字符串      "".equals(s)   s.equals("")
        //      boolean = s.isEmpty();   ""  null   s==null

        //matches       正则表达式

    }
}
