package java代码.集合解释.List类;

import java.util.LinkedList;

public class LinkedList类 {
    LinkedList<Integer> link=new LinkedList<>();

    /**
     *  方法名称	说明
     *     void addFirst(E e)	将指定元素添加到此集合的开头
     *     void addLast(E e)	将指定元素添加到此集合的末尾
     *     E getFirst()	返回此集合的第一个元素
     *     E getLast()	返回此集合的最后一个元素
     *     E removeFirst()	删除此集合中的第一个元素
     *     E removeLast()	删除此集合中的最后一个元素
     * @param args
     */
    public static void main(String[] args) {
    LinkedList<String> products = new LinkedList<String>(); // 创建集合对象
    String p1 = new String("六角螺母");
    String p2 = new String("10A 电缆线");
    String p3 = new String("5M 卷尺");
    String p4 = new String("4CM 原木方板");
    products.add(p1); // 将 p1 对象添加到 LinkedList 集合中
    products.add(p2); // 将 p2 对象添加到 LinkedList 集合中
    products.add(p3); // 将 p3 对象添加到 LinkedList 集合中
    products.add(p4); // 将 p4 对象添加到 LinkedList 集合中
    String p5 = new String("标准文件夹小柜");
    products.addLast(p5); // 向集合的末尾添加p5对象
    System.out.print("*************** 商品信息 ***************");
    System.out.println("\n目前商品有：");
    for (int i = 0; i < products.size(); i++) {
        System.out.print(products.get(i) + "\t");
    }
    System.out.println("\n第一个商品的名称为：" + products.getFirst());
    System.out.println("最后一个商品的名称为：" + products.getLast());
    products.removeLast(); // 删除最后一个元素
    System.out.println("删除最后的元素，目前商品有：");
    for (int i = 0; i < products.size(); i++) {
        System.out.print(products.get(i) + "\t");
    }
}
}
