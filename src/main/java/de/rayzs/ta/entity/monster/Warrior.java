package de.rayzs.ta.entity.monster;

import de.rayzs.ta.entity.EntityMonster;

public class Warrior extends EntityMonster {

    public Warrior(int health, int level) {
        super("Warrior", health, level);
        a(1, 4, "kick")
                .a(4, 10, "sword slice")
                .a(2, 6, "head nut")
                .a(1, 3, "side kick")
                .a(3, 5, "jump attack");
    }
}
