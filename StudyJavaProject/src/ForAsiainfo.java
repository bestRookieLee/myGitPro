import java.util.ArrayList;
import java.util.List;

public class ForAsiainfo {
    public static void main(String[] args) {
        int i = 1;
        //i++;
        //System.out.println(i);
        //后++ 执行完之后 变量值就会变化
        //比如 i++ + i++ 第二个i值 的初始值为第一个i++ 之后的结果
        //2+2+3
        //后++ 单目运算符作为一项时，先计算 ，然后变量值会变，++i 作为单目运算符的一项时，变化之后的值参加运算。
        System.out.println(++i + i++ + i++);//结果应该是几
        System.out.println("123".concat("123"));"123".length();
        List<String> ls = new ArrayList<>();
        ls.size();
        String []s = new String[4];
        int length = s.length;
     }
}
