import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveSameNum {
    public static void main(String[] args) {
        int [] nums = {1,2,3,3};
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}
