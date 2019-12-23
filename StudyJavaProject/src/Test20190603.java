public class Test20190603 {
    public static void main(String[] args) {
        String s = ":172.16.24.220:2181";
        String[] ss = s.split(":");
        for (String sss : ss) {
            System.out.println(sss);
        }
    }
}
