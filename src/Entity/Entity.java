package Entity;

public abstract class Entity {
    public int positionX;
    public int positionY;
    public int width;
    public int height;
    public Hitbox hitbox;


    public Entity(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        hitbox = new Hitbox(this, this.positionX, this.positionY, this.width, this.height);
    }
}
