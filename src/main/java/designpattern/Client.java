package designpattern;

public class Client {
    private ClothesFactory clothesFactory;
    private ClothesRepository clothesRepository;

    public Client(ClothesFactory clothesFactory, ClothesRepository clothesRepository) {
        this.clothesFactory = clothesFactory;
        this.clothesRepository = clothesRepository;
    }

    public void createClothes(String number, String name) {
        Clothes clothes = clothesFactory.createClothes(number, name);
        clothesRepository.save(clothes);
    }
}
