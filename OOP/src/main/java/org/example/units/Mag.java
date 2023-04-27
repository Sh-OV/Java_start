package org.example.units;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Mag extends BaseHero {
    protected int manna;
    protected String[] book_spells;

    public Mag(int initiative, float hp, int step, int attack, int def, int damageMin, int damageMax, int team, int posX, int posY,
               int manna, String[] book_spells) {
        super(initiative, hp, step, attack, def, damageMin, damageMax, team, posX, posY);
        this.manna = manna;
        this.book_spells = book_spells;
    }
    protected BaseHero search_ally_hp(ArrayList<BaseHero> search_ally){
        BaseHero ally = search_ally.get(0);
        for (BaseHero friend : search_ally) {
            if(friend.hp <= 0){
                ally = friend;
            }
        }
        return ally;
    }
    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> ally) {

    }
    public void accessing_hp_ally(BaseHero pers, int ratio){                // метод для лечения / воскрешения
        pers.hp *= ratio;
    }

}
