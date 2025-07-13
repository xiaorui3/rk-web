package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class main1 {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        Collections.addAll(arr,1,2,3,4,5,6,7,8,9);
        //Stream<Integer> stream = arr.stream();
        arr.stream().forEach(integer -> System.out.print(integer+" "));
        Map<String,Integer> map=new HashMap<>();
        map.put("1234",123);
        map.put("2345",234);
        System.out.println();
        map.keySet().stream().forEach(s-> System.out.print(map.get(s)+" "));
    }
}
