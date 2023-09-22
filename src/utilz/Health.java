package utilz;

import Entity.Entity;
import game.HealthBar;

public class Health {

    public Entity entity;
    public HealthBar healthBar;
    public int healthPoints;

    public Health(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
}
