package org.example.units;

public class Spearman extends BaseHero {
    protected int gian;     // увеличение удара при разбеге

    public Spearman(String name, int x, int y) {
        super(name, x, y, 45, 6, 18, 6, new int[]{8,12}, true);
        this.gian = 20;
    }
}
