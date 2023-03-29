package org.example.units;

public class Outlaw extends BaseHero {
    protected int gian;     // увеличение удара при разбеге

    public Outlaw(String name, int x, int y) {
        super(name, x, y, 40, 6, 18, 8, new int[]{8,12}, false);
        this.gian = 20;
    }
}
