public class Dragon extends Entity{
    private String color;

    Dragon(String color, int x, int y) {
        super(x, y);
        this.color = color;
    }
    public String getColor() {return this.color;}

    @Override
    public String toString() {
        return "The " + this.color + " dragon breathing fire at (" +
                super.getPosition().x + " , " + super.getPosition().y +")";
    }
}