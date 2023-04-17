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
    public static int team;


    public BaseHero(int x, int y, float hp, int step, int attack, int def, int[] damage, int team) {
        this.name = getName();
        this.x = Coordinates.start_coord_X();
        this.y = Coordinates.start_coord_Y();
        this.hp = hp;
        this.max_hp = hp;
        this.step = step;
        this.attack = attack;
        this.def = def;
        this.damage = damage;
        this.team = team;
    }
    private static String getName(){

        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }
    @Override
    public String toString(){
        return (name + " , " + x + " , " + y);
    }
}

