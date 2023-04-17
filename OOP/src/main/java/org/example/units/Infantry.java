package org.example.units;

import java.util.ArrayList;

public abstract class Infantry extends BaseHero{
    protected  int gian;     // увеличение удара при разбеге
    public Infantry(int x, int y, float hp, int step, int attack, int def, int[] damage, int team,
                    int gian) {
        super(x, y, hp, step, attack, def, damage, team);
        this.gian = gian;
    }

    @Override
    public void step(ArrayList<BaseHero> enemy_team) {

    }

}
