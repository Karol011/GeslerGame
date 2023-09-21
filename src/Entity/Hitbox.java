package Entity;

import java.awt.*;

public class Hitbox {

    public Entity entity;
    public int positionX;
    public int positionY;
    public int width;
    public int height;

    public Hitbox(Entity entity, int positionX, int positionY, int width, int height) {
        this.entity = entity;
        this.positionX = positionX;
        this.positionY = positionY;
        this.width = width;
        this.height = height;
    }

    public void displayHitbox(Graphics g,int positionX, int positionY) {
        g.setColor(Color.pink);
        g.drawRect(positionX,positionY, this.width, this.height);
    }


}
