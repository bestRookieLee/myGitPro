public class Test20190715 {
    public static void main(String[] args) {
        String s = "25156";
        //"%04d" 表示数字不够四位左边补零
        //当数字超过四位 比如 25156时 原本数字不变
        s = String.format("%04d", Integer.valueOf(s));
        System.out.println(s);
    }
}
