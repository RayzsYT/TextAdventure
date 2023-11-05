package de.rayzs.ta.entity;

import de.rayzs.ta.console.Console;

public class EntityMonster extends EntityAttack implements Entity {

    private int health, level;
    private String name;

    public EntityMonster(String name, int health, int level) {
        this.name = name;
        this.health = health;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public EntityType type() {
        return EntityType.MONSTER;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int dealDamage(int damage) {
        return level == 1 ? damage : damage + ((damage * level)/2);
    }

    @Override
    public int receiveDamage(int damage) {
        health -= damage;
        return damage;
    }

    @Override
    public void die() {
        Console.i("%s died!", name);
    }
}
