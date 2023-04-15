package org.example.units;

import java.util.Random;

public abstract class BaseHero implements GameInterface {
    protected String       name;           // Имя игрока-персонажа
    protected int       x, y;           // Координаты
    protected float     hp, max_hp;             // Здоровье
    protected int       step,           // Шаг (количество клеток)
                        attack,         // Атака
                        def;            // Защита
    protected int[]     damage;         // минимальный и максимальный ущерб


    public BaseHero(int x, int y, float hp, int step, int attack, int def, int[] damage) {
        this.name = getName();
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.max_hp = hp;
        this.step = step;
        this.attack = attack;
        this.def = def;
        this.damage = damage;
    }
    private static String getName(){

        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }
    @Override
    public String toString(){
        return name;
    }
}

