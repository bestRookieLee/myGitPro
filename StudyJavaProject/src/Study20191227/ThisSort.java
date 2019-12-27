package Study20191227;

import com.alibaba.fastjson.JSON;

import java.util.TreeSet;

public class ThisSort {
    public static void main(String[] args) {
        TreeSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(5);
        sortedSet.add(8);
        sortedSet.add(6);
        sortedSet.add(3);
        sortedSet.add(7);
        sortedSet.add(2);
        sortedSet.add(5);
        System.out.println("sortedSet:" + sortedSet);
        //
        int[] leftInt=new int[sortedSet.size()];
        int j=sortedSet.size() - 1;
        for (Integer integer : sortedSet) {
            leftInt[j]=integer;
            j--;
        }
        System.out.println(JSON.toJSONString(leftInt));
    }
}
