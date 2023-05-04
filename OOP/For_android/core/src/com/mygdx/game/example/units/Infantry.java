package com.mygdx.game.example.units;

import org.example.View;

import java.util.ArrayList;

public abstract class Infantry extends BaseHero{
    protected  int gian;     // увеличение удара при разбеге
    public Infantry(int initiative, float hp, int step, int attack, int def, int damageMin, int damageMax, int team, int posX, int posY,
                    int gian) {
        super(initiative, hp, step, attack, def, damageMin, damageMax, team, posX, posY);
        this.gian = gian;
    }

    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> ally) {
        if(hp <= 0){
            this.condition = " \uD83D\uDC80 Dead";
            return;
        }
        BaseHero enemy_pers = enemy.get(find_closest_enemy(enemy));
        BaseHero ally_pers = ally.get(find_closest_ally(ally));
        coords.getCoord_move(enemy_pers.coords, ally_pers.coords);
        if(coords.getDistance(enemy_pers.coords) < 2) {
            accessing_hp_enemy(enemy_pers);
            System.out.println(toString() + " атакует " + enemy_pers.toString());
            return;
        }
        System.out.println(toString() + " идёт атаковать " + enemy_pers.toString());
    }

}
