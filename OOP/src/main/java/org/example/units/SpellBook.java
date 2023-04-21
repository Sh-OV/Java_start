package org.example.units;

public enum SpellBook {
    lightning(10, -4),
    slowly(4, -0.5f),
    speed(4, 0.5f),
    ressurect(25, Float.NaN),
    heal(20, 0.3f),
    shield(10, 4);
//    damageOne(1, 1), damageFive(5, 2), damageTen(10, 3);

    private final float cost, power;

    SpellBook(float cost, float power){
        this.cost = cost;
        this.power = power;
    }

    public float getCost(){
        return cost;
    }

    public float getPower() {
        return power;
    }
}
