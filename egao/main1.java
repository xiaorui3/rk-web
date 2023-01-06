package egao;

public class main1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Str a=new Str("abc",18);
        String p="abc";
        StringBuilder sb=new StringBuilder("abc");
        System.out.println(a.equals(p));
        System.out.println(p.equals(sb));
        System.out.println(sb.equals(p));
        Str a1=new Str();
        a.a11= new int[]{1, 2, 3, 4, 5, 6};
        a1= (Str)a.clone();
        System.out.println(a);
        for(int i=0;i<a.getA().length;i++){
            System.out.print(a.a11[i]+",");
        }
        a1.age=10;
        a1.setName("zhaorui");
        a1.a11[0]=100;
        System.out.println(a1);
        for(int i=0;i<a1.getA().length;i++){
            System.out.print(a1.a11[i]+",");
        }
        System.out.println(a);
        for(int i=0;i<a.getA().length;i++) {
            System.out.print(a.a11[i] + ",");
        }
    }
}
