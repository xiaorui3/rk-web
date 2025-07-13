package 异常;

public class main1 {
    public static void main(String[] args) {
        Student[] arr=new Student[3];
        //String name=arr[0].getName();
        try{
            String name=arr[0].getName();
        }
        catch (NullPointerException e){
            //System.out.println("错误");
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("----错误----");
        }
        System.out.println("执行了吗");
    }
}
