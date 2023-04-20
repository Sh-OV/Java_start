package org.example.units;

import java.util.ArrayList;

public abstract class Shooter extends BaseHero {
    protected  int arrows,             // количество стрел остаток после каждого удара?
                   maxArrows,          // количество стрел максимально в начале боя
                   accuracy;           // точность

    public Shooter(int initiative, float hp, int step, int attack, int def, int[] damage, int team,
                   int arrows, int accuracy) {
        super(initiative, hp, step, attack, def, damage, team);
        this.arrows = arrows;
        maxArrows = arrows;
        this.accuracy = accuracy;
    }
    protected boolean search_ally_peasant(ArrayList<BaseHero> search_ally){
        boolean existence = false;
        for (BaseHero friend : search_ally) {
            if(friend.getInfo() == "Крестьянин - " && friend.hp > 0){
                existence = true;
            }
        }
        return existence;
    }
    protected void shoot(){
    }

       @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> ally) {
        if(hp <= 0 || (arrows <= 0 && !search_ally_peasant(ally))) return;
        find_closest_enemy(enemy);
        arrows = maxArrows - this.arrows;
       }
}
