package org.example.units;

import java.util.ArrayList;

public abstract class Shooter extends BaseHero {
    protected  int arrows,             // количество стрел остаток после каждого удара?
                   maxArrows,          // количество стрел максимально в начале боя
                   accuracy;           // точность

    public Shooter(int initiative, float hp, int step, int attack, int def, int damageMin, int damageMax, int team, int posX, int posY,
                   int arrows, int accuracy) {
        super(initiative, hp, step, attack, def, damageMin, damageMax, team, posX, posY);
        this.arrows = arrows;
        maxArrows = arrows;
        this.accuracy = accuracy;
    }
    protected boolean search_ally_peasant(ArrayList<BaseHero> search_ally){     // поиск крестьянина
        for (BaseHero friend : search_ally) {
            if(friend.getInfo() == "Фермер - " &&
               friend.hp > 0 &&
               friend.condition == "Stand"){
                friend.condition = "Busy";
                return true;
            }
        }
        return false;
    }
       @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> ally) {
        if(hp <= 0){
            this.condition = "Dead";
            return;
        }
        else if (arrows <= 0){
            this.condition = "Empty";
            return;
        }
        BaseHero enemy_pers = ally.get(find_closest(enemy));
        accessing_hp_enemy(enemy_pers);
        if (!search_ally_peasant(ally)) {
               arrows = maxArrows - 1;
           }
        System.out.println(this.toString() + " атаковал " + enemy_pers.toString());
       }
}
