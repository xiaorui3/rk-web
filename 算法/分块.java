package 算法;

public class 分块 {
    public static void main(String[] args) {
        int []arr={16,5,9,12,21,18,
                32,23,37,26,45,34,
                50,48,61,52,73,66};
        BLock b1=new BLock(21,0,5);
        BLock b2=new BLock(45,6,11);
        BLock b3=new BLock(73,12,17);
        int number=39;
        BLock[] Arr1={b1,b2,b3};
        int fanhui = fanhui(Arr1, arr, number);
        if(fanhui<0){
            System.out.println("不存在");
        }
        else{
            System.out.println(fanhui);
        }
    }
//    public static int chazhao(BLock[] Arr,int[] arr,int number){
//
//    }
    public static int fanhui(BLock[] Arr,int[] arr,int number){
        for(int i=0;i<Arr.length;i++){
            if(number<=Arr[i].getMax()){
                for(int j=0;j<(Arr[i].getEnd()-Arr[i].getStart());j++){
                    if(arr[Arr[i].getStart()+j]==number) {
                        return Arr[i].getStart()+j;
                    }
                }
                //int chazhao = chazhao(Arr, arr, number);
            }
        }return -1;
    }
    static class BLock{
        private int max;
        private int start;
        private int end;

        public BLock() {
        }

        public BLock(int max, int start, int end) {
            this.max = max;
            this.start = start;
            this.end = end;
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
            return "BLock{max = " + max + ", start = " + start + ", end = " + end + "}";
        }
    }
}
