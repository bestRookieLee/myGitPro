package testFactory;

public class ConCreateFactoryB implements FactoryMethod{
    @Override
    public Product createProduct() {
        return new ConCreateProductB();
    }
}