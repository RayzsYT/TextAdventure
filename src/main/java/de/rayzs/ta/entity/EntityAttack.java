package de.rayzs.ta.entity;

import de.rayzs.ta.console.Console;
import de.rayzs.ta.util.MathUtils;
import java.util.*;

public class EntityAttack {

    public final List<Attack> attacks = new ArrayList<>();

    public EntityAttack a(int minDamage, int maxDamage, String message) {
        Attack attack = new Attack(minDamage, maxDamage, message);
        attacks.add(attack);
        return this;
    }

    public void attack(Entity attacker, Entity victim) {
        attacks.get(MathUtils.RANDOM.nextInt(attacks.size())).handleDamage(attacker, victim);
    }

    public class Attack {

        private final int minDamage, maxDamage;
        private final String attackName;

        public Attack(int minDamage, int maxDamage, String attackName) {
            this.minDamage = minDamage;
            this.maxDamage = maxDamage;
            this.attackName = attackName.toUpperCase();
        }

        public void handleDamage(Entity attacker, Entity victim) {
            int damage = MathUtils.nextInt(minDamage, maxDamage);
            attacker.dealDamage(damage);
            victim.receiveDamage(damage);
            int remainingHealth = victim instanceof EntityPlayer ? ((EntityPlayer) victim).getHealth() : ((EntityMonster) victim).getHealth();
            Console.i("%s attacked %s with %s (-%s)! %s has %shp left.",
                    attacker.name(), victim.name(), attackName, victim.name(), String.valueOf(remainingHealth));
        }
    }
}
