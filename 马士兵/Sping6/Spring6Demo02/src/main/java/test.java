public class test {
    public static void main(String[] args) {
        String a = "hello";
        String b = "hello";
        String c = new String("hello");
        String d = c.intern();

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(c == d);

        String e = "hel" + "lo";
        String f = "hel";
        String g = f + "lo";
        System.out.println(a == e);
        System.out.println(a == g);
    }
}