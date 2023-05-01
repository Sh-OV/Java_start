package org.example.units;

import java.util.ArrayList;
import java.util.HashMap;

import static org.example.units.SpellBook.*;

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
                    manna -= ressurect.getCost();
                    break;
                }
            }
        }
        if (getInfo() == "Волшебник - " && manna >= heal.getCost()){
            for (BaseHero hero : ally) {
                if (hero.hp < hero.max_hp) {
                    hero.hp = (attack + def) * heal.getPower();
                }
            }
            manna -= heal.getCost();
        }
        else if (manna >= lightning.getCost()){
            if (coords.getDistance(enemy_pers.coords) <= 4){
                def *= (int) (1 + shield.getPower());
            }
            else enemy_pers.hp -= lightning.getPower();
            manna -= lightning.getCost();
        }
        else if (manna >= fist.getCost()){
            enemy_pers.hp -= fist.getPower();
            manna -= fist.getCost();
        }
        else condition = " O Empty";
    }
}
