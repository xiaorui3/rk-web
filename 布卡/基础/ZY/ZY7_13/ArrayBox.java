package 布卡.基础.ZY.ZY7_13;


public class ArrayBox<E> {
    public ArrayBox(){}
    private Object[] arr=new Object[10];
    int sum=0;
    int length=10;
    public boolean add(E a){
        if (sum>length-1){
            int m=length;
            this.length= (int) (this.length*1.5);
            Object[] array=new Object[length];
            for (int i = 0; i < m; i++) {
                array[i]=this.arr[i];
            }
            this.arr=array;
        }
        this.arr[this.sum]= a;
        this.sum++;
        return true;
    }
    public E get(int index) throws Exception {
        if (this.sum<index){
            Exception e =new Exception();
            e.printStackTrace();
            throw e;
        }
        return (E) this.arr[index];
    }
    public boolean re(int index) throws Exception {
        if (this.sum<index){
            Exception e =new Exception();
            e.printStackTrace();
            throw e;
        }
        for (int i = index; i < this.sum; i++) {
            if (i!=sum){
                this.arr[i]=this.arr[i+1];
            }
        }
        this.sum--;
        return true;
    }
    public boolean show(){
        for (int i = 0; i < this.sum; i++) {
            System.out.print(this.arr[i]+" ");
        }
        return true;
    }

    public boolean show_max(){
        for (int i = 0; i < this.length; i++) {
            System.out.print(this.arr[i]+" ");
        }
        return true;
    }

}
