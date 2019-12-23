package Study20190820;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TestSet20190820 {
    public static void main(String[] args) {
        //hasSet是不排序的
        //Set<String> nameSet = new HashSet<>();
        //LinkedHashSet 保留装入的顺序
        Set<String> nameSet = new LinkedHashSet<>();
        nameSet.add("小花");
        nameSet.add("小红");
        nameSet.add("小丽丽");
        for (String sname : nameSet) {
            System.out.println(sname);
        }
        List<String> nameList = new ArrayList<>(nameSet);
        for (String lname : nameList) {
            System.out.println(lname);
        }
    }
}
