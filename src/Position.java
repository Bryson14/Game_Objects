public class Position{
    public int x;
    public int y;

    Position() {
        this.x = 0;
        this.y = 0;
    }

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return"("+ this.x + ", "+ this.y + ")";
    }

}