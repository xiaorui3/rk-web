package w14;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 * @author xiaorui
 */
public class main1 {
    static Scanner lu=new Scanner(System.in);
    static int number=lu.nextInt();
    static int[] arr=new int[number];
    static ArrayList<Integer> list=new ArrayList<>();
    static ArrayList<number_list> numberLists=new ArrayList<>();
    public static void main(String[] args) {
        int number1=0;
        for(int i=0;i<number;i++){
            arr[i]=lu.nextInt();
        }
        int m=0;
        for(int p=9;p!=0;p--){
            for(int i=0;i<number;i++){
                int k_1=0;
                for(int j=0;j<number;j++){
                    int k=arr[j];
                    int k1=0;
                    while (k!=0){
                        k1=k;
                        k=k/10;
                    }
                    if(k1==p){
                        int f=1;
                        for(int y=0;y< list.size();y++){
                            if(arr[j]==list.get(y)){
                                f=-1;
                            }
                        }
                        if(f>0){
                            list.add(arr[j]);
                            k_1++;
                            m++;
                        }
                    }
                    if(k_1>=2){
                        for(int o=0;o<k_1-1;o++){
                            if(list.get(m-o-1)> list.get(m-o-2)){
                                //int o_1=list.get(m-o);
                                Collections.swap(list, m-o-1, m-o-2);
                                //list.get(m-o)=list.get(m-o+1);
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }

//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]);
//        }
    }
    public static int print(int[] arr){
        return 0;
    }
}
class number_list{
    int min;
    int max;
    int mid;
    int start;
    int end;

    public number_list() {
    }

    public number_list(int min, int max, int mid, int start, int end) {
        this.min = min;
        this.max = max;
        this.mid = mid;
        this.start = start;
        this.end = end;
    }

    /**
     * 获取
     * @return min
     */
    public int getMin() {
        return min;
    }

    /**
     * 设置
     * @param min
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * 获取
     * @return max
     */
    public int getMax() {
        return max;
    }

    /**
     * 设置
     * @param max
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * 获取
     * @return mid
     */
    public int getMid() {
        return mid;
    }

    /**
     * 设置
     * @param mid
     */
    public void setMid(int mid) {
        this.mid = mid;
    }

    /**
     * 获取
     * @return start
     */
    public int getStart() {
        return start;
    }

    /**
     * 设置
     * @param start
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * 获取
     * @return end
     */
    public int getEnd() {
        return end;
    }

    /**
     * 设置
     * @param end
     */
    public void setEnd(int end) {
        this.end = end;
    }

    public String toString() {
        return "number_list{min = " + min + ", max = " + max + ", mid = " + mid + ", start = " + start + ", end = " + end + "}";
    }
}