package test20190719;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSort {
    public static void main(String[] args) {
        List<String> sList = new ArrayList<>();
        sList.add("a");
        sList.add("c");
        sList.add("b");
        //Collections.sort(sList);
        Collections.sort(sList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if("b".equals(o1) && !"b".equals(o2)) {
                    return 1;
                } else if ("b".equals(o2) && !"b".equals(o1)){
                    return -1;
                }else{
                    return o1.compareTo(o2);
                }
            }
        });

        // 返回-1 说明 o1 < o2
        // 返回1 说明 o2 < o1
        // 返回0 说明 o2 = o1
        //最终list会顺序发送
        int count = sList.size();
        for (String s : sList){
            System.out.println("第" +count+ "大的元素:" + s);
            count--;
        }
        // --果然还是后算的
//        int a = 5;
//        int i = a--/5;
//        System.out.println(i);
    }
}
