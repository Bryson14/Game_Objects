public class Entity{
    private Position myPos = new Position();

    Entity(int x, int y) {
        myPos.x = x;
        myPos.y = y;
    }

    public void setPosition(int x, int y) {
        myPos.x = x;
        myPos.y = y;
    }
    public Position getPosition() {
        return myPos;
    }
}