package T20190813;

import java.util.function.Function;

public class T20190812 {
    public static void main(String[] args) {
        Function<Integer, Integer> name = e -> e * 2;
        Function<Integer, Integer> square = e -> e * e;
        //先执行调用者，再执行参数
        int value = name.andThen(square).apply(3);
        System.out.println("andThen value=" + value);
        //先执行参数在执行调用者
        int value2 = name.compose(square).apply(3);
        System.out.println("compose value2=" + value2);
        //返回一个执行了apply()方法之后只会返回输入参数的函数对象
        Object identity = Function.identity().apply("huohuo");
        System.out.println(identity);
    }
}
