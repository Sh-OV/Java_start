package org.example.units;

public abstract class BaseHero implements GameInterface {
    public String       name;           // Имя игрока-персонажа
    protected int       x, y;           // Координаты
    protected float     hp;             // Здоровье
    protected int       step,           // Шаг (количество клеток)
                        attack,         // Атака
                        def;            // Защита
    protected int[]     damage;         // минимальный и максимальный ущерб
    protected boolean   command;        // команда 1 или 2 (если 1 то true, 2 - false

    public BaseHero(String name, int x, int y, float hp, int step, int attack, int def, int[] damage, boolean command) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.step = step;
        this.attack = attack;
        this.def = def;
        this.damage = damage;
        this.command = command;
    }

    @Override
    public String toString(){
        return name;
    }
}

