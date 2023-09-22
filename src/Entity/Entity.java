package Entity;

import game.HealthBar;
import utilz.Health;

public abstract class Entity {
    public int positionX;
    public int positionY;
    public int width = 64;
    public int height = 64;
    public Hitbox hitbox;
    public HealthBar healthBar;
    public Health healthPoints;


    public Entity(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        hitbox = new Hitbox(this, this.positionX, this.positionY, this.width, this.height);
        healthBar = new HealthBar(this);
        healthPoints = new Health(15);
    }
}
