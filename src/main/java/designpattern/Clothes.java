package designpattern;

public class Clothes {
    private String number;
    private String brand;
    private String type;

    public Clothes() {
    }

    public Clothes(String number, String brand) {
        this.number = number;
        this.brand = brand;
    }

    public String getNumber() {
        return number;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
