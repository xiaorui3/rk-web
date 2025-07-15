package leetcode.简单;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class 两数相加 {
    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> arr1=new ArrayList<>();
        for (; l1.val!=0 ; l1=l1.next) {
            arr1.add(l1.val);
        }
        ArrayList<Integer> arr2=new ArrayList<>();
        for (; l2.val!=0 ; l2=l2.next) {
            arr2.add(l2.val);
        }
        Collections.reverse(arr1);
        Collections.reverse(arr2);

        for (int i = arr1.size()-1; i >=0; i--) {
            Integer i1 = arr1.get(i);

        }
        return l1;
    }

}
