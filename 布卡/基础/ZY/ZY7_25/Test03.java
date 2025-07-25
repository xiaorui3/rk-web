package 布卡.基础.ZY.ZY7_25;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Test03 {
    public static void main(String[] args) {
        ArrayDeque<String> q=new ArrayDeque<>();

        q.push("1");
        q.push("2");
        q.push("3");

        System.out.println(q.peek());

        Stack<String> s =new Stack<>();

        s.push("1");
        s.push("2");
        s.push("3");

        System.out.println(s.peek());

    }
}
