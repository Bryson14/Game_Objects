import java.util.ArrayList;

public class Hero extends Entity{
    private String name;
    private ArrayList<Treasure> Inventory = new ArrayList<>();

    public Hero () {
        super(0,0);
        this.name = "Ulrich Von Liechtenstein";
    }

    public Hero (String name, int x, int y) {
        super(x,y);
        this.name = name;
    }

    public String getName() {return this.name;}

    @Override
    public String toString() {
        return String.format("%s standing at (%d , %d)", this.name, super.getPosition().x, super.getPosition().y);
    }

    public void attack(Entity E) {
        if (E instanceof Dragon && ((Dragon) E).getColor() == "Golden") {
            Inventory.add(Treasure.Coins);
        } if (E instanceof Crate) {
            Inventory.add(((Crate) E).getTreasure());
        }
    }

    public ArrayList getTreasures() {
        return Inventory;
    }
}