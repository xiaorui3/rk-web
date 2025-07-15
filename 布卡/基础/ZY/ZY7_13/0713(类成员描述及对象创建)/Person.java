package 布卡.基础.ZY.ZY7_13;

public class Person {

    //方法重载
//    public int test(){
//        System.out.println("我是无参方法");
//        return 0;
//    }
//    protected String test(int a){
//        System.out.println("我是int方法"+a);
//        return "";
//    }
//    public void test(char c){
//        System.out.println("我是char方法");
//    }
//    public double test(String s){
//        System.out.println("我是String方法");
//        return 0;
//    }

//    public void test(int... b){     //数组
//        for(int i=0;i<b.length;i++){
//            System.out.println(b[i]);
//        }
//        System.out.println("我是可变参数的方法");
//    }

//    public void test(int[] arr){
//
//    }


    //============================================

//
//    //属性        写法像是变量
//    //  权限修饰符 [特征修饰符] 数据类型 属性名字 [= 值];
    public String name;         //private
    public int age;
    public char sex;
//
//    //方法
//    //  权限修饰符 [特征修饰符] 返回值类型 方法名字 ([参数列表]) [方法抛出异常] {方法体}
    public void study(){
        System.out.println("学习");
    }
//
//    //=============================================
//
//    public int testOne(int a){
//        System.out.println("方法内开始："+a);//1
//        a = 1000;
//        System.out.println("方法内最终："+a);//1000
//        return a;   //返回值  a空间里面那个值1000
//    }
//
//    public void testTwo(int[] array){
//        System.out.println("方法内开始："+array[0]);//1
//        array[0] = 1000;
//        System.out.println("方法内最终："+array[0]);//1000
//    }

    //============================================

    //构造方法
    //  既然他是方法，也是用来做事情的
    //  但是前面加上了一个限定的修饰，构造？  构造什么东西呢？
    //  可以理解为是一个非常特殊的方法，特殊在哪儿(功能上，具体做的事情上)
    //      只用来做一件事------->确定的，就是用来构建当前类的对象
    //
    //  因为返回的类型就是当前类的类型，类型是确定的，返回类型的结构省去了
    //  但是这个方法，肯定有返回值，返回值就是一个当前类的对象
    //  构造方法的方法名，与类名必须相同
    //  类中的所有成员(属性，方法-变量)   所有名字都是小驼峰

    //  权限修饰符 Person(参数) {
    //      构建一个Person类的对象
    //      应该将构建的Person对象返回出来
    //  }

    //如果构造方法，本身就存在，那我们还有必要自己描述构造方法嘛？
    //构造方法的作用是唯一的，就是用来构建当前类的对象
    //我们如果想要在构建对象的同时，做一点自己的事情，做一点我们希望的别的事情


    public Person(){}

    public Person(String name,int age,char sex){
        //构建对象的同时，给属性赋值
        //1.构建一个对象------>堆内存申请空间
        //对象空间  this(指代词，代替的是当前构建出来的那个对象)
        //2.给属性赋值
        this.name = name;       //this既然代替的是对象
        this.age = age;         //调用属性，调用方法
        this.sex = sex;

        System.out.println("我是带参数的构造方法");
        //3.对象返回出去
        //return obj;
    }


    //代码块
    //  将代码块理解成一个非常特殊的方法
    //      特殊在写法上，没有修饰符，没有参数和返回值，连名字也没有
    //      只剩下一个执行体
    //  既然连名字都没有，不用我们调用，每一次构建对象之前(构造方法执行之前)，自动调用的

    {
        System.out.println("我是代码块");
    }

}
