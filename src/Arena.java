import java.util.ArrayList;

public class Arena {
    private int sizeX;
    private int sizeY;
    private ArrayList<Entity[]> arenaMap = new ArrayList<>();

    Arena(int sizeX, int sizeY) {
        for (int i = 0; i < sizeY; i++) {
            arenaMap.add(new Entity[sizeX]); //new the keyword add so it makes new references and not 10 of the same references
        }
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public ArrayList<Entity[]> getGrid() {
        return arenaMap;
    }

    public boolean add(Entity E) { //need to update print statements
        boolean added = false;
        //System.out.println("\n What is it?: " + (arenaMap.get(E.getPosition().y)[E.getPosition().x] ));
        if (isHeroThere() && E instanceof Hero) { //adding a hero when a hero is already there
            System.out.printf( "\n Could not add %s because there is already a hero in the arena.", E.toString());

        } else if (arenaMap.get(E.getPosition().y)[E.getPosition().x] != null && E instanceof Dragon) { //adding a dragon to a filled spot
            System.out.printf("\n Could not add %s because another dragon is already there.", E.toString());

        } else if (arenaMap.get(E.getPosition().y)[E.getPosition().x] != null && E instanceof Crate) { //adding a crate to a filled spot
            System.out.printf("\n Could not add %s because another crate is already there.", E.toString());

        }else if (arenaMap.get(E.getPosition().y)[E.getPosition().x] != null) { //adding an entity to a filled spot
            System.out.printf("\n Could not add %s because another entity is already there.", E.toString());

        } else { //if there's no problem, add the entity
            arenaMap.get(E.getPosition().y)[E.getPosition().x] = E;
            added = true;
        } return added;
    }

    public void moveHero(int x, int y) {
        Hero hero = ((Hero)getHero()); //stores a reference to original hero

        if (arenaMap.get(y)[x] != null) {
            hero.attack(arenaMap.get(y)[x]);
        }

        arenaMap.get(hero.getPosition().y)[hero.getPosition().x] = null; //deletes reference to hero in old spot
        hero.setPosition(x,y); //updates hero's position in his class
        arenaMap.get(y)[x] = hero ; //moves hero reference to new location
    }

    public Hero getHero() { //returns the reference
        int foundCell = 0;
        int foundRow = 0;
        for (int row = 0; row < sizeY ; row++) {
            for (int cell = 0; cell < sizeX; cell++) { //searching every cell
                if (arenaMap.get(row)[cell] instanceof Hero) {
                    foundCell = cell;
                    foundRow = row;
                }
            }
        }return (Hero)arenaMap.get(foundRow)[foundCell];
    }

    public boolean isHeroThere() { //returns true if hero is in the arena
        boolean heroPresent = false;
        for (int row = 0; row < sizeY ; row++) {
            for (int cell = 0; cell < sizeX; cell++) { //searching every cell
                if (arenaMap.get(row)[cell] instanceof Hero) {
                    heroPresent = true;
                }
            }
        }return heroPresent;
    }

    public int getTreasureCount() { //returns the total number of treasure
        int treasureCount = 0;
        for (int row = 0; row < sizeY; row++) {
            for (int cell = 0; cell < sizeX; cell++) { //searching every cell
                Entity space = arenaMap.get(row)[cell];
                if (space instanceof Crate) {
                    treasureCount++;
                }
            }
        }return treasureCount;
    }

    public int getTreasureCount(Treasure T) {
        int specificTreasureCount = 0;
        for (int row = 0; row < sizeY; row++) {
            for (int cell = 0; cell < sizeX; cell++) { //searching every cell
                Entity space = arenaMap.get(row)[cell];
                if (space instanceof Crate) {
                    if (((Crate) space).getTreasure() == T) {
                        specificTreasureCount++;
                    }
                }
            }
        } return specificTreasureCount;
    }

    public int getEntityCount() {
        int entityCount = 0;
        for (int row = 0; row < sizeY ; row++) {
            for (int cell = 0; cell < sizeX; cell++) { //searching every cell
                if (arenaMap.get(row)[cell] instanceof Entity) {
                    entityCount++;
                }
            }
        } return entityCount;
    }

    public int getDragonCount() {
        int dragonCount = 0;
        for (int row = 0; row < sizeY; row++) {
            for (int cell = 0; cell < sizeX; cell++) { //searching every cell
                if (arenaMap.get(row)[cell] instanceof Dragon) {
                    dragonCount++;
                }
            }
        } return dragonCount;
    }

    public void reportHero() {
        System.out.println("--- Hero Report for " + ((Hero) getHero()).getName() +" ---\n");
        System.out.printf("Position: %s \n", ((Hero) getHero()).getPosition());
        System.out.println("Treasure:");
        ArrayList<Treasure> listOfTreasure = (getHero()).getTreasures();
        for (int i = 0; i < listOfTreasure.size(); i++) {
            System.out.println(listOfTreasure.get(i));
        }
    }
//    public void arenaStatus() {
//        System.out.println("\n --- Arena status after moving the hero ---\n ");
//        System.out.printf("\n There are %d entities", getEntityCount());
//        System.out.printf("\n There are %d dragons", getDragonCount());
//        System.out.printf("\n There are %d wood treasures", getTreasureCount(Treasure.Wood));
//        System.out.printf("\n There are %d statue treasures", getTreasureCount(Treasure.Statue));
//        System.out.printf("\n There are %d food treasures", getTreasureCount(Treasure.Food));
//        System.out.printf("\n There are %d coin treasures", getTreasureCount(Treasure.Coins));
//        System.out.printf("\n There are %d rag treasures /n", getTreasureCount(Treasure.Rags));
//
//    }
}
