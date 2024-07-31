package designpattern;

public class ShirtsFactory implements ClothesFactory {

    @Override
    public Clothes create() {
        return new Shirts();
    }
}
