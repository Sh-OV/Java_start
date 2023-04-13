package org.example.units;

public abstract class Shooter extends BaseHero {
    int     arrows,             // количество стрел
            accuracy;           // точность

    public Shooter(String name, int x, int y, float hp, int step, int attack, int def, int[] damage, boolean command, int arrows, int accuracy) {
        super(name, x, y, hp, step, attack, def, damage, command);
        this.arrows = arrows;
        this.accuracy = accuracy;
    }

    protected void shoot(){
        System.out.println("Shoot!");
    }
}
