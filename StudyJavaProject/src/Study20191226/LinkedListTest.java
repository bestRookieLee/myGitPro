package Study20191226;

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("addd");//add
        /**
         * 改变指定下表的元素值，
         * 在此之前需要保证这个index有对应元素
         */
        linkedList.set(0,"saaa");
        linkedList.add("666");
        linkedList.add("666");
        String s = linkedList.get(0);
        System.out.println(s);
        System.out.println(JSON.toJSONString(linkedList));
        //出现两个相同元素从最后一个开始删？
        linkedList.remove("666");
        System.out.println(linkedList.contains("666"));
        System.out.println(JSON.toJSONString(linkedList));

        ArrayDeque adeque = new ArrayDeque();

    }
}
