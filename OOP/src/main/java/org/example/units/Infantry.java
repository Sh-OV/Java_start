package org.example.units;

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
        }
        System.out.println(this.toString() + " идёт атаковать " + enemy_pers.toString());

    }
 /*   protected void getCoord_move (BaseHero enemy){
        System.out.println(toString() + ", this.coords.posX = " + coords.posX + ", this.coords.posY = " + coords.posY + ", \n" +
                enemy.toString() + ", enemy_pers.coords.posX = " + enemy.coords.posX + ", enemy_pers.coords.posY = " + enemy.coords.posY);
        int move_x = enemy.coords.posX - coords.posX;
        int move_y = enemy.coords.posY - coords.posY;
        System.out.println("Math.abs(move_x) = " + Math.abs(move_x) + ", Math.abs(move_y) = " + Math.abs(move_y));
        System.out.println("Math.signum(move_x) = " + (int) Math.signum(move_x) + "\n" +
                "Math.signum(move_y) = " + (int) Math.signum(move_y));
        if (Math.abs(move_x) > Math.abs(move_y))
            coords.posX += (int) Math.signum(move_x);
        else coords.posY += (int) Math.signum(move_y);
        System.out.println("Xism = " + coords.posX + ", Yism = " + coords.posY);
    }*/



}
