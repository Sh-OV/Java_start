package org.example.units;

public class Crossbowman extends BaseHero {
    int     arrows,             // количество стрел
            accuracy;           // точность

    public Crossbowman(String name, int x, int y) {
        super(name, y, x, 30, 3, 15, 6, new int[]{10, 20}, true);
        this.arrows = 10;
        this.accuracy = 70;
    }
}
