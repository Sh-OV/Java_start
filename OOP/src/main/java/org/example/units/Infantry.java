package org.example.units;

import java.util.ArrayList;

public abstract class Infantry extends BaseHero{
    protected  int gian;     // увеличение удара при разбеге
    public Infantry(int initiative, float hp, int step, int attack, int def, int[] damage, int team, String stat,
                    int gian) {
        super(initiative, hp, step, attack, def, damage, team, stat);
        this.gian = gian;
    }

    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> ally) {

    }

}
