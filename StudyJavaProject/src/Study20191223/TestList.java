package Study20191223;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List<Integer> baseList = new ArrayList<>();
        baseList.add(1);
        baseList.add(2);
        List<Integer> baseList2 = new ArrayList<>();
        baseList2.add(3);
        baseList2.add(2);
        //baseList 和 baseList2的交集返回给baseList
        baseList.retainAll(baseList2);
        System.out.println(baseList.toString());

        //并集使用 addAll方法 差集使用removeAll方法

    }
}
