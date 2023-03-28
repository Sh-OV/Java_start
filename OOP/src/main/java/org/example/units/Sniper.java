package org.example.units;

public class Sniper extends BaseHero {
    int arrows,             // количество стрел
            accuracy;           // точность

    public Sniper(String name, int x, int y) {
        super(name, x, y, 7, 3, 12, 3, new int[]{6, 12});
        this.arrows = 10;
        this.accuracy = 70;
    }
}