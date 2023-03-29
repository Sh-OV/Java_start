package org.example.units;

public class Sniper extends BaseHero {
    int     arrows,             // количество стрел
            accuracy;           // точность

    public Sniper(String name, int x, int y) {
        super(name, y, x, 35, 3, 15, 5, new int[]{10, 20}, false);
        this.arrows = 9;
        this.accuracy = 80;
    }
}