package 布卡.基础.ZY.ZY7_16;

public class UseLinkBox {
    public static void main(String[] args) {
        LinkBox<String> l =new LinkBox<>();
        l.add("1");
        l.add("2");
        l.add("3");
        l=l.getNext();
        while(l!=null){
            System.out.println(l.getE());
            l=l.getNext();
        }
    }
}
