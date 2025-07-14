package 布卡.基础.ZY.ZY7_13;

public class ArrayBox1 {

    //属性，就是用来存储数据的真实位置
    private int[] elements = new int[10];

    //给用户提供两个方法

    //用户给我提供一个数据，我负责存起来
    //  参数？用户需要存储的那个数据      int
    public void add(int element){       //10次
        //判断容器空格还不够不
        //如果够了就直接存
        //如果不够，自己去扩容    新数组比原来那个长，原来数组元素挪过来
    }

    //给用户提供一个方法，可以将存入的某个数据拿回去
    //  参数？第几个数据？       index
    public int get(int index){

        return 0;
    }

    //给用户提供一个方法，可以删除某个元素
    //  参数？返回值？



}
