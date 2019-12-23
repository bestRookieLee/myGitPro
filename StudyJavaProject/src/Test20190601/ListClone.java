package Test20190601;

import java.util.ArrayList;
import java.util.List;

public class ListClone {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("string1");
        List<String> strList2 = (List<String>) ((ArrayList<String>) strList).clone();
        //List<String> strList2 = strList;
        strList2.add("string2");
        System.out.println(strList.toString());
    }
}
