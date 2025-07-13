package 算法;

public class 分块1 {
    public static void main(String[] args) {
        int[] arr={27,22,30,40,36,
                13,19,16,20,7,10,
                43,50,48};
        int number=7;
        fenkuai b1=new fenkuai(22,40,0,4);
        fenkuai b2=new fenkuai(7,20,5,10);
        fenkuai b3=new fenkuai(43,50,11,13);
        fenkuai[] b={b1,b2,b3};
        int extracted = extracted(arr, number, b);
        System.out.println(extracted);
    }
    private static int extracted(int[] arr, int number, fenkuai[] b) {
        for(int i=0;i<3;i++){
            if(number >= b[i].getMin()&& number <= b[i].getMax()){
                for(int j=0;j<=b[i].getIndex2()-b[i].getIndex1();j++){
                    if(arr[(b[i].getIndex1()+j)]==number){
                        return b[i].getIndex1()+j;
                    }
                }
            }
        }
        return -1;
    }
}
class fenkuai{
    int min;
    int max;
    int index1;
    int index2;

    public fenkuai() {
    }

    public fenkuai(int min, int max, int index1, int index2) {
        this.min = min;
        this.max = max;
        this.index1 = index1;
        this.index2 = index2;
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
     * @return index1
     */
    public int getIndex1() {
        return index1;
    }

    /**
     * 设置
     * @param index1
     */
    public void setIndex1(int index1) {
        this.index1 = index1;
    }

    /**
     * 获取
     * @return index2
     */
    public int getIndex2() {
        return index2;
    }

    /**
     * 设置
     * @param index2
     */
    public void setIndex2(int index2) {
        this.index2 = index2;
    }

    public String toString() {
        return "fenkuai{min = " + min + ", max = " + max + ", index1 = " + index1 + ", index2 = " + index2 + "}";
    }
}
