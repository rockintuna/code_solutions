package designpattern;

public interface ClothesFactory {

    default Clothes createClothes(String number, String brand) {
        validateArguments(number, brand);
        Clothes clothes = create();
        clothes.setNumber(number);
        clothes.setNumber(brand);
        return clothes;
    }

    private static void validateArguments(String number, String brand) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("number is blank.");
        }
        if (brand == null || brand.isBlank()) {
            throw new IllegalArgumentException("number is blank.");
        }
    }

    Clothes create();
}
