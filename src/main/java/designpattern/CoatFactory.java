package designpattern;

public class CoatFactory implements ClothesFactory {

    @Override
    public Clothes create() {
        return new Coat(2);
    }
}
