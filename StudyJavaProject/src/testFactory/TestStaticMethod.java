package testFactory;

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Dictionary;
        import java.util.HashMap;
        import java.util.List;

public class TestStaticMethod {
    public static void doSomeThis (){
        System.out.println("do somethig");
    }
    public TestStaticMethod(){
        System.out.println("haha");
    }

    public static void main(String[] args) {
        TestStaticMethod.doSomeThis(); //直接使用类名调用方法的形式不会走到该类的构造方法
        TestStaticMethod testStaticMethod = new TestStaticMethod();

        Collections.synchronizedMap(new HashMap<>());
        String[] s = new String[10];
        int len = s.length;
        List<String> list1 = new ArrayList<>();
        list1.size();
    }
}
