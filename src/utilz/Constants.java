package utilz;

public class Constants {

    public static class PlayerConstants {
        public static final int CAST_MAGIC_UP = 0;
        public static final int CAST_MAGIC_LEFT = 1;
        public static final int CAST_MAGIC_DOWN = 2;
        public static final int CAST_MAGIC_RIGHT = 3;

        public static final int ATTACK_SPEAR_UP = 4;
        public static final int ATTACK_SPEAR_LEFT = 5;
        public static final int ATTACK_SPEAR_DOWN = 6;
        public static final int ATTACK_SPEAR_RIGHT = 7;

        public static final int WALKING_UP = 8;
        public static final int WALKING_LEFT = 9;
        public static final int WALKING_DOWN = 10;
        public static final int WALKING_RIGHT = 11;

        public static final int OPEN_DOORS_UP = 12;
        public static final int OPEN_DOORS_lEFT = 13;
        public static final int OPEN_DOORS_DOWN = 14;
        public static final int OPEN_DOORS_RIGHT = 15;

        public static final int FIGHT_UP = 16;
        public static final int FIGHT_LEFT = 17;
        public static final int FIGHT_DOWN = 18;
        public static final int FIGHT_RIGHT = 19;

        public static final int DYING = 20;

        public static final int ATTACK_ROD_UP = 21;
        public static final int ATTACK_ROD_LEFT = 22;
        public static final int ATTACK_ROD_DOWN = 23;
        public static final int ATTACK_ROD_RIGHT = 24;


        public static int GetSpritesAmount(int playerAction) {
            switch (playerAction) {
                case OPEN_DOORS_DOWN, OPEN_DOORS_RIGHT, OPEN_DOORS_lEFT, OPEN_DOORS_UP, DYING -> {
                    return 6;
                }
                case CAST_MAGIC_DOWN, CAST_MAGIC_LEFT, CAST_MAGIC_RIGHT, CAST_MAGIC_UP -> {
                    return 7;
                }
                case ATTACK_SPEAR_DOWN, ATTACK_SPEAR_LEFT, ATTACK_SPEAR_RIGHT, ATTACK_SPEAR_UP -> {
                    return 8;
                }
                case WALKING_DOWN, WALKING_UP, WALKING_LEFT, WALKING_RIGHT -> {
                    return 9;
                }
                case FIGHT_UP, FIGHT_DOWN, FIGHT_RIGHT, FIGHT_LEFT, ATTACK_ROD_UP, ATTACK_ROD_DOWN, ATTACK_ROD_LEFT, ATTACK_ROD_RIGHT -> {
                    return 13;
                }
                default -> {
                    return 2;
                }
            }

        }
    }
}
