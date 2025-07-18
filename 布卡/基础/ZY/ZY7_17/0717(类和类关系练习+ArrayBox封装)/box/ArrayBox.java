package box;

//架构师的角度思考
public class ArrayBox<E> {//我

    //为了保证底层数组存储的通用性，用了一个Objcet[]
    //  1.真正使用box的人，通常不会乱七八糟的乱存
    //  2.最好在封装代码的底层，对未来用户使用的时候，做一个类型的约束
    //          定义泛型        遵循泛型
    //          <当前类中存在一个类型的约束>     <element>


    //用来存储数组默认容量大小的属性-----10
    private static final int DEFAULT_CAPACITY = 10;

    //属性，真实的数组，用来存储数据的容器
    private Object[] elementData;
    //属性，用来存储当前数据的位置(有效元素的个数)
    private int size;


    /**
     * 无参数构造方法
     */
    //提供两个构造方法
    public ArrayBox(){
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    /**
     *
     * @param capacity  用户提供的初始化数组长度
     */
    public ArrayBox(int capacity){
        this.elementData = new Object[capacity];
    }



    ////////////////////////////////////////////////////////////

    //设计一个小弟方法------小A
    //  条件？int需要存储数据的最小容量       void--->
    private void ensureCapacity(int minCapacity){
        if(minCapacity - elementData.length > 0){
            //扩容        1.新容量---计算  2.新空间产生
            this.grow(minCapacity);
        }
    }

    //  计算--->算法本身可能就有点麻烦   小B
    //      需要条件么   minCapacity         void------>
    private void grow(int minCapacity){
        //1.找到原数组的长度
        int oldCapacity = elementData.length;
        //2.先根据旧数组的长度，初步算一下     1.5-2倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        //3.如果经过经验的计算，发现还不够
        if(newCapacity - minCapacity < 0){
            newCapacity = minCapacity;
        }
        elementData = this.copyOf(newCapacity,elementData);
    }

    //  负责创建新数组，将旧的元素移动过去
    //      新数组的长度int，旧数组
    private Object[] copyOf(int newCapacity,Object[] oleArray){
        //1.根据newCapacity创建一个新数组
        Object[] newArray = new Object[newCapacity];
        //2.移动元素
        for(int i=0;i<oleArray.length;i++){
            newArray[i] = oleArray[i];
        }
        //3.方法内创建的新数组返回出去
        return newArray;
    }

    //方法用来检测index的范围
    private void rangeCheck(int index){
        if(index<0 || index>=size){     //length-10     size-6      get(7);
            //告诉人家有问题？？？------->异常(类-对象)      认为规定的一种不正常现象
            //      编译时异常           运行时异常
            //throw new BoxIndexOutOfBoundsException("你这个index越界啦");
        }
    }

    ////////////////////////////////////////////////////////////
    //设计方法
    //用来存储数据        条件？数据       返回值？boolean

    /**
     * @param element   参数用来传递存入的数据
     * @return          存储是否成功
     */
    public boolean add(E element){
        //确保当前自己属性数组里面得有容量
        this.ensureCapacity(size+1);
        //数据存入我自己的数组里
        elementData[size++] = element;
        //告知用户，存成功啦
        return true;
    }

    //扩展
//    public void add(int element,int index){
//
//    }
//    public void addAll(Box box){
//
//    }
//    public void remove(int element){
//
//    }
//    public void removeAll(){
//
//    }

    /**
     *
     * @param index     获取元素的位置
     * @return          获取元素
     */
    //用来获取数据        条件？位置        返回值？数据
    public E get(int index){
        //严谨性判断     index有效的        范围
        this.rangeCheck(index);
        //去我的属性数组里取
        return (E)elementData[index];
    }

    /**
     *
     * @param index     删除元素的位置
     * @return          删除的元素
     */
    //可以删除数组元素
    //  条件？哪个index          返回值？数据
    public E remove(int index){           //remove(9)
        this.rangeCheck(index);
        //去数组里，找到index位置，数据存起来
        E oldValue = (E)elementData[index];
        //10,20,30,40,50,60,0,0,0,0             size==6     0-5index
        //10,20,40,50,60,60,0,0,0,0              size-1
        //      i=2 3 4
        for(int i=index;i<size-1;i++){
            elementData[i] = elementData[i+1];
        }
        //有效元素个数减少一个
        //size--;     //5
        //手动将最后的那个60--->0
        elementData[--size] = null;
        return oldValue;
    }

    /**
     *
     * @return  有效元素的个数
     */
    public int size(){
        return this.size;
    }


}
