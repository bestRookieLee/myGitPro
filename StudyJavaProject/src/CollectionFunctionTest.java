import com.alibaba.fastjson.JSON;
import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionFunctionTest {
    public static void main(String[] args) {
        // list的交并补方法
        forAdd_remove_retain();
        getListHasInitValue();
    }


    private static void forAdd_remove_retain(){
        List<Integer> baseList = new ArrayList<>();
        baseList.add(1);
        baseList.add(2);
        List<Integer> baseList2 = new ArrayList<>();
        baseList2.add(3);
        baseList2.add(2);
        //baseList 和 baseList2的交集返回给baseList
        baseList.retainAll(baseList2);
        System.out.println(baseList.toString());
        // 并集使用addAll 差集使用removeAll
    }

    private static void getListHasInitValue(){
        // 先创建然后添加元素
        List<String> methodOne = new ArrayList<>();
        methodOne.add("1");
        methodOne.add("2");
        methodOne.add("3");
        System.out.println("methodOne:" + JSON.toJSONString(methodOne));

        // {{}} 语法
        List<String> methodTwo = new ArrayList<String>(){{
            add("4");
            add("5");
            add("6");
        }};
        System.out.println("methodTwo:" + JSON.toJSONString(methodTwo));

        /**
         * 使用 Arrays.asList
         * Arrays.asList 返回的是 Arrays 的静态内部类（静态内部类不持有所在外部类的引用）。
         * 这个内部类继承自 AbstractList，实现了 RandomAccess，内部使用了一个数组来存储元素。
         * 但是不支持增删元素。这点需要注意。如果只是使用 Arrays.asList 来初始化常量，那么这点就不算什么问题了。
         */
        List<String> methodThree = Arrays.asList("as","qw","er");
        System.out.println("methodThree:" + JSON.toJSONString(methodThree));
        /**
         * jdk1.8  使用stream 单纯的数据初始化使用stream有点大材小用
         */
        List<String> methodFour = Stream.of("a", "b", "c").collect(Collectors.toList());
        /**
         * jdk1.9 目前jdk暂时不可用
         * List<String> list = Lists.newArrayList("a", "b", "c");
         *
         */
    }
}
