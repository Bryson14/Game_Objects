public class Crate extends Entity{
    private Treasure item;

    Crate(Treasure item, int x, int y) {
        super(x, y);
        this.item = item;
    }

    public Treasure getTreasure() {
        return item;
    }

    @Override
    public String toString() {
        return "Crate with " + item + " at (" +
                super.getPosition().x + ", " + super.getPosition().y +")";
    }

}