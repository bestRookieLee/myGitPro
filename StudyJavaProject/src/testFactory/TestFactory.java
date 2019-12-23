package testFactory;

public class TestFactory {
    public static void main(String[] args) {
//        FactoryMethod factoryA = new ConCreateFactoryA();
//        FactoryMethod factoryB = new ConCreateFactoryB();
//        Product productA = factoryA.createProduct();
//        Product productB = factoryB.createProduct();
//        productA.operation1("想出门");
//        productB.operation1("想回家");
        doWhatIWant("A", " 回家 ");
        doWhatIWant("B", " 探亲 ");
    }

    public static void doWhatIWant(String productType, String wantdo){
        switch (productType){
            case "A":
                FactoryMethod factoryA = new ConCreateFactoryA();
                Product productA = factoryA.createProduct();
                productA.operation1(wantdo);
                break;
            case "B":
                FactoryMethod factoryB = new ConCreateFactoryB();
                Product productB = factoryB.createProduct();
                productB.operation1(wantdo);
                break;
            default:
                break;
        }
    }
}
