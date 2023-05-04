package com.mygdx.game.example.units;

import static com.mygdx.game.example.units.SpellBook.*;

import java.util.ArrayList;

public abstract class Mag extends BaseHero {
    protected int manna;
    protected SpellBook book_spells;


    public Mag(int initiative, float hp, int step, int attack, int def, int damageMin, int damageMax, int team, int posX, int posY,
               int manna, String[] book_spells) {
        super(initiative, hp, step, attack, def, damageMin, damageMax, team, posX, posY);
        this.manna = manna;
 //       book_spells = new SpellBook(cost, power);
    }

    @Override
    public String toString() {
        return super.toString() + " manna = " + manna;
    }

    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> ally) {
        if(hp <= 0){
            this.condition = " \uD83D\uDC80 Dead";
            return;
        }
        BaseHero enemy_pers = enemy.get(find_closest_enemy(enemy));
        if (getInfo() == "Маг - " && manna >= ressurect.getCost()) {
            for (BaseHero hero : ally) {
                if (hero.hp <= 0) {
                    hero.hp = hero.max_hp * ressurect.getPower();
                    if (hero.hp > hero.max_hp) hero.hp = hero.max_hp;
                    manna -= ressurect.getCost();
                    System.out.println(toString() + " воскрешает " + hero.toString());
                    break;
                }
            }
        }
        if (getInfo() == "Волшебник - " && manna >= heal.getCost()){
            for (BaseHero hero : ally) {
                if (hero.hp < hero.max_hp) {
                    hero.hp = (attack + def) * heal.getPower();
                    if (hero.hp > hero.max_hp) hero.hp = hero.max_hp;
                    System.out.println(toString() + " лечит " + hero.toString() + " +❤" + (attack + def) * heal.getPower());
                }
            }
            manna -= heal.getCost();
        }
        else if (manna >= lightning.getCost()){
            if (hp < max_hp || coords.getDistance(enemy_pers.coords) <= 4){
                def *= (int) (1 + shield.getPower());
                System.out.println(toString() + " ставит на себя щит " + enemy_pers.toString());
            }
            else enemy_pers.hp -= lightning.getPower();
            System.out.println(toString() + " бьет молнией " + enemy_pers.toString());
            manna -= lightning.getCost();
        }
        else if (manna >= fist.getCost()){
            enemy_pers.hp -= fist.getPower();
            System.out.println(toString() + " бьет кулаком " + enemy_pers.toString());
            manna -= fist.getCost();
        }
        else condition = " O Empty";
    }
}
