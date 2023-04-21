package org.example.units;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Mag extends BaseHero {
    protected int manna;
    protected HashMap<String, ArrayList<String>> book_spells;

    public Mag(int initiative, float hp, int step, int attack, int def, int[] damage, int team, String[] stat,
               int manna, HashMap<String, ArrayList<String>> book_spells) {
        super(initiative, hp, step, attack, def, damage, team, stat);
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
}
