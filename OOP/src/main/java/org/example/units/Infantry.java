package org.example.units;

public abstract class Infantry extends BaseHero{
    int gian;     // увеличение удара при разбеге
    public Infantry(int x, int y, float hp, int step, int attack, int def, int[] damage,
                    int gian) {
        super(x, y, hp, step, attack, def, damage);
        this.gian = gian;
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return null;
    }
}