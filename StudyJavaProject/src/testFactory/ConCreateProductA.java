package testFactory;

public class ConCreateProductA implements Product{
    @Override
    public void operation1(String wantdo) {
        System.out.println("productA" + wantdo);
    }
}
