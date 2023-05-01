package org.example.units;

public enum SpellBook {
    lightning(10, 4),      // молния
    fist(3, 1),             // кулак
    ressurect(25, 0.8f),     // воскрешение
    heal(20, 0.3f),         // лечение
    shield(10, 4);          // щит

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
