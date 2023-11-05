package de.rayzs.ta.entity;

import de.rayzs.ta.console.Console;

public class EntityPlayer extends EntityAttack implements Entity {

    private int health, level, crystals, defensive, attackBoost;
    private String name;

    public EntityPlayer(String name) {
        this.name = name;
        this.health = 100;
        this.level = 1;
        this.crystals = 15;
        this.defensive = 0;
        this.attackBoost = 0;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public int getCrystals() {
        return crystals;
    }

    public int getAttackBoost() {
        return attackBoost;
    }

    public int getDefensive() {
        return defensive;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public EntityType type() {
        return EntityType.PLAYER;
    }

    @Override
    public int receiveDamage(int damage) {
        int reduce = defensive != 0 ? (damage / 100) * defensive : 0,
                finalDamage = damage - reduce;
        health -= finalDamage;
        return finalDamage;
    }

    @Override
    public int dealDamage(int damage) {
        int boost = attackBoost != 0 ? (damage / 100) * attackBoost : 0;
        return damage + boost;
    }

    @Override
    public void die() {
        try {
            Console.i("You died! Game will close in 5 seconds.");
            Thread.sleep(5000);
            System.exit(-1);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
