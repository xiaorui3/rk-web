package 异常;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.IntUnaryOperator;

public class main2 {
    public static void main(String[] args) {
        //int [] arr={1,2,3,4,98,6,7,8,46};
        int [] arr= {};
        //OptionalInt max = Arrays.stream(arr).max();
        //System.out.println(max.getAsInt());
        try {
            System.out.println(max(arr));
        } catch (NullPointerException e) {
            System.out.println("空指针异常");
            throw new RuntimeException(e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界异常");
            throw new RuntimeException(e);
        }
    }
    public static int max(int[] a)throws NullPointerException,ArrayIndexOutOfBoundsException{
        if(a==null){
            throw new NullPointerException();
        }
        if(a.length==0){
            throw new ArrayIndexOutOfBoundsException();
        }
        int p=a[0];
        for (int i = 0; i < a.length; i++) {
            if(p<a[i]){
                p=a[i];
            }
        }
        return p;
    }
}
