package org.example.units;

public abstract class Infantry extends BaseHero{
    int gian;     // увеличение удара при разбеге
    public Infantry(String name, int x, int y, float hp, int step, int attack, int def, int[] damage, boolean command) {
        super(name, x, y, hp, step, attack, def, damage, command);
        this.gian = gian;
    }
}
