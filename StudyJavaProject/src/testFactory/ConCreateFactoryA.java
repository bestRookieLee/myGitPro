package testFactory;

public class ConCreateFactoryA implements FactoryMethod{
    @Override
    public Product createProduct() {
        return new ConCreateProductA();
    }
}