package designpattern;

public class Coat extends Clothes{

    private int buttons;

    public int getButtons() {
        return buttons;
    }

    public void setButtons(int buttons) {
        this.buttons = buttons;
    }

    public Coat(int buttons) {
        super();
        this.setButtons(buttons);
        this.setType("Shirts");
    }
}
