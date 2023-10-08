package de.rayzs.ta.entity;

public interface Entity {
    String name();
    EntityType type();
    int receiveDamage(int damage);
    int dealDamage(int damage);
    void onDie();
}
