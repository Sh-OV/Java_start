package org.example.units;

import java.util.ArrayList;

public abstract class Shooter extends BaseHero {
    protected  int arrows,             // количество стрел остаток после каждого удара?
                   maxArrows,          // количество стрел максимально в начале боя
                   accuracy;           // точность

    public Shooter(int initiative, float hp, int step, int attack, int def, int[] damage, int team, String stat,
                   int arrows, int accuracy) {
        super(initiative, hp, step, attack, def, damage, team, stat);
        this.arrows = arrows;
        maxArrows = arrows;
        this.accuracy = accuracy;
    }
    protected boolean search_ally_peasant(ArrayList<BaseHero> search_ally){     // поиск крестьянина
        boolean existence = false;
        for (BaseHero friend : search_ally) {
            if(friend.getInfo() == "Крестьянин - " &&
               friend.hp > 0 &&
               friend.stat == "stand"){
                friend.stat = "busy";
                existence = true;
                return existence;
            }
        }
        return existence;
    }
       @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> ally) {
        if(hp <= 0){
            this.stat = "dead";
            return;
        }
        else if (arrows <= 0){
            this.stat = "empty";
            return;
        }
        BaseHero enemy_pers = find_closest_enemy(enemy);
        accessing_hp_enemy(enemy_pers);
        if (!search_ally_peasant(ally)) {
               arrows = maxArrows - 1;
           }
        System.out.println(this.toString() + " атаковал " + enemy_pers.toString());
       }
}
