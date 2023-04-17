package org.example.units;

import java.util.ArrayList;

public abstract class Shooter extends BaseHero {
    protected  int arrows,             // количество стрел остаток после каждого удара?
                   maxArrows,          // количество стрел максимально в начале боя
                   accuracy;           // точность

    public Shooter(int x, int y, float hp, int step, int attack, int def, int[] damage, int team,
                   int arrows, int accuracy) {
        super(x, y, hp, step, attack, def, damage, team);
        this.arrows = arrows;
        maxArrows = arrows;
        this.accuracy = accuracy;
    }

    protected void shoot(){
    }

       @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> ally) {
        if(hp <= 0 || arrows <= 0) return;
        find_closest_enemy(enemy);

       }

}
