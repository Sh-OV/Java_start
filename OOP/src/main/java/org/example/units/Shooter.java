package org.example.units;

public abstract class Shooter extends BaseHero {
    int     arrows,             // количество стрел остаток после каждого удара?
            maxArrows,          // количество стрел максимально в начале боя
            accuracy;           // точность

    public Shooter(int x, int y, float hp, int step, int attack, int def, int[] damage,
                   int arrows, int accuracy) {
        super(x, y, hp, step, attack, def, damage);
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
