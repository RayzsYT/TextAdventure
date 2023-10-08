package de.rayzs.ta.entity.monster;

import de.rayzs.ta.entity.EntityMonster;

public class Slime extends EntityMonster {

    public Slime(int health, int level, int damage) {
        super("Slime", health, level, damage);
        a(1, 4, "jump attack");
    }
}
