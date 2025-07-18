package box;

import java.util.ArrayList;

public class TestMain {

    public static void main(String[] args) {
        //真正能用来存储数的地方
        //变量，数组                         对象(属性-值)，对象(属性-值)，对象(属性-值)
        //变量-----栈内存，只能存一个信息
        //数组-----堆内存，能存多个信息
        //      底层，地址连续，长度固定
        //      好处：因为地址连续，循环遍历快
        //      不好：长度固定，插入/删除不行的
        //自己描述一个类型
        //      作用替代数组(不是完全替代，如果你的场景刚好是数组不好的那些)

        //用户角度(未来的使用者，程序员，雪姐)
        //雪姐，很多学生的名字，存起来

        //存，取，遍历
//        ArrayBox<String> box = new ArrayBox();
//        box.add("abc");
//
//        String value = box.get(0);




//        box.add(10);    //size          //box[0] = 10;      box.add(10);
//        box.add(20);    //size
//        box.add(30);    //size

//        for(int i=0;i<box.size();i++){
//            int v = box.get(i);
//            System.out.println(v);
//        }

        //1.扩展，可以将我刚才写的那几个空的方法，，，添加实现
        //2.存在的问题：
        //      灵活的创建
        //      底层数组存储的数据只能是int


//        Object o = box.get(0);



//        for(int i=1;i<=16;i++){
//            box.add(1);
//        }

//        for(int i=0;i<box.elementData.length;i++){
//            System.out.print(box.elementData[i]);
//        }
//        System.out.println("size"+box.size);


//        box.get(2);
//        box.get(4);


//        ArrayList<String> list = new ArrayList(20);
//        boolean b = list.add("abc");
//        String value = list.get(0);
//        String old = list.remove(0);
//        int size = list.size();
//
//        "zzz".charAt(0);


    }
}
