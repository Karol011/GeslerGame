package game;


import Entity.Entity;

public class CollisionManager {

    Game game;

    public CollisionManager(Game game) {
        this.game = game;
    }

        public boolean areColliding(Entity obj1, Entity obj2) {
            // Calculate the bounds of each object
            int obj1Left = obj1.positionX;
            int obj1Right = obj1.positionX + obj1.width;
            int obj1Top = obj1.positionY;
            int obj1Bottom = obj1.positionY + obj1.height;

            int obj2Left = obj2.positionX;
            int obj2Right = obj2.positionX + obj2.width;
            int obj2Top = obj2.positionY;
            int obj2Bottom = obj2.positionY + obj2.height;

            // Check for intersection in x and y axes
            boolean LTcollision = obj1Left < obj2Right;
            boolean RTcollision = obj1Right > obj2Left;
            boolean LDcollision = obj1Bottom > obj2Top;
            boolean RDcollision = obj1Top < obj2Bottom;

            return obj1Right > obj2Left
                    && obj1Left < obj2Right
                    && obj1Bottom > obj2Top
                    && obj1Top < obj2Bottom;
    }

}
