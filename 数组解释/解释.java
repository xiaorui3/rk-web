package java代码.数组解释;

public class 解释 {
    public static void main(String[] args) {
        /**
         * 1、Arrays.toString()打印数组
         *
         * 此处的Arrays.toString()方法是Arrays类的静态方法，不是前面讲的Object的toString()方法。
         *
         * import java.util.Arrays;
         * public class Test {
         *     public static void main(String args[]) {
         *         int[] a = { 1, 2 };
         *         System.out.println(a); // 打印数组引用的值；
         *         System.out.println(Arrays.toString(a)); // 打印数组元素的值；
         *     }
         * }
         * 2、Arrays.equals(int[] a, int[] a2)比较两个数组是否相同
         *
         * import java.util.Arrays;
         * public class Test {
         *     public static void main(String args[]) {
         *         int [] arrA={23,34,345,234};
         *         int [] arrB={23,34,345,234};
         *         //两个数组以相同的顺序包含相同的元素
         *         System.out.println(Arrays.equals(arrA, arrB));//true
         *         //(2)Arrays.equals(...)与Object中的equals方法有什么不同？
         *         System.out.println(arrA.equals(arrB));//false
         *     }
         * }
         * 3、Arrays.copyOf(int[] original, int newLength)复制指定的数组---效率低，会重新开辟新的数组空间original - 要复制的数组;newLength - 要返回的副本的长度
         *
         * import java.util.Arrays;
         * public class Test {
         *     public static void main(String args[]) {
         *         int [] arrA={23,34,345,234};
         *         int [] arrB=new int[5];//默认值0
         *         System.out.println("拷贝前："+arrB);
         *         arrB=Arrays.copyOf(arrA, 5);  //重新开辟空间
         *         System.out.println("拷贝后："+arrB);
         *         System.out.println(Arrays.toString(arrB));
         *     }
         * }
         * 4、Arrays.fill(int[] a, int val)/Arrays.fill(int[] a, int fromIndex, int toIndex, int val)
         * * 填充数组
         *
         * import java.util.Arrays;
         * public class Test {
         *     public static void main(String[] args) {
         *         int[] a= {1,2,323,23,543,12,59};
         *         System.out.println(Arrays.toString(a));
         *         Arrays.fill(a, 2, 4, 100);  //将2到4索引的元素替换为100;前闭后开
         *         System.out.println(Arrays.toString(a));
         *         Arrays.fill(a, 55);
         *         System.out.println(Arrays.toString(a));
         *     }
         * }
         * 5、Arrays.sort(int[] a);对数组进行升序排序
         *
         * import java.util.Arrays;
         * public class Test {
         *     public static void main(String args[]) {
         *         int[] a = {1,2,323,23,543,12,59};
         *         System.out.println(Arrays.toString(a));
         *         Arrays.sort(a);
         *         System.out.println(Arrays.toString(a));
         *     }
         * }
         * 数组元素是引用类型的排序(Comparable接口的应用)
         *
         * import java.util.Arrays;
         * public class Test {
         *     public static void main(String[] args) {
         *         Man[] msMans = {new Man(3, "a"), new Man(60, "b"),new Man(2, "c")};
         *         Arrays.sort(msMans);
         *         System.out.println(Arrays.toString(msMans));
         *     }
         * }
         *
         * class Man implements Comparable {
         *     int age;
         *     int id;
         *     String name;
         *
         *     public Man(int age, String name) {
         *         super();
         *         this.age = age;
         *         this.name = name;
         *     }
         *
         *     public String toString() {
         *         return this.name;
         *     }
         *
         *     public int compareTo(Object o) {
         *         Man man = (Man) o;
         *         if (this.age < man.age) {
         *             return -1;
         *         }
         *         if (this.age > man.age) {
         *             return 1;
         *         }
         *         return 0;
         *     }
         * }
         * 6、Arrays.binarySearch(int[] a, int key)二分法查找
         *
         * import java.util.Arrays;
         * public class Test {
         *     public static void main(String[] args) {
         *         int[] a = {1,2,323,23,543,12,59};
         *         System.out.println(Arrays.toString(a));
         *         Arrays.sort(a);   //使用二分法查找，必须先对数组进行排序;
         *         System.out.println(Arrays.toString(a));
         *         //返回排序后新的索引位置,若未找到返回负数。
         *         System.out.println("该元素的索引："+Arrays.binarySearch(a, 12));
         *     }
         * }
         */
    }
}
