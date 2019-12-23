package T20190728;

public class test {
    public static void main(String[] args) {
        parent p = new parent();
        //children c = (children) p;
        children c = new children();
        parent p2 = (parent) c;

    }
}
