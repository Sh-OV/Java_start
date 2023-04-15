package org.example.units;

public abstract class Shooter extends BaseHero {
    int     arrows,             // количество стрел остаток после каждого удара?
            maxArrows,          // количество стрел максимально в начале боя
            accuracy;           // точность

    public Shooter(String name, int x, int y, float hp, int step, int attack, int def, int[] damage, boolean command, int arrows, int accuracy) {
        super(name, x, y, hp, step, attack, def, damage, command);
        this.arrows = arrows;
        maxArrows = arrows;
        this.accuracy = accuracy;
    }

    public void shoot(){
        System.out.println("Shoot!");
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return null;
    }
}
