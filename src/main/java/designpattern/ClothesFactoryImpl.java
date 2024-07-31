package designpattern;

public class ClothesFactoryImpl {
    public Clothes createClothes(String number, String brand) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("number is blank.");
        }
        if (brand == null || brand.isBlank()) {
            throw new IllegalArgumentException("number is blank.");
        }

        Clothes clothes = new Clothes(number, brand);

        if (number.startsWith("ST-")) {
            clothes.setType("shirts");
        }
        if (number.startsWith("PT-")) {
            clothes.setType("pants");
        }
        if (number.startsWith("CT-")) {
            clothes.setType("coat");
        }
        if (number.startsWith("JN-")) {
            clothes.setType("jean");
        }
        if (number.startsWith("JP-")) {
            clothes.setType("jumper");
        }

        return clothes;
    }
}
