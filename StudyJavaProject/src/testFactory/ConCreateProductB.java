package testFactory;

public class ConCreateProductB implements Product{
    @Override
    public void operation1(String wantdo) {
        System.out.println("productB" + wantdo);
    }
}
