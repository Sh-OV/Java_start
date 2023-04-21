package org.example.units;

import java.util.ArrayList;


public class Peasant extends BaseHero {
    public Peasant(int team) {
        super(2, 50,8, 5, 3, new int[]{15,30}, team, "stand");
    }

    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> ally) {
    }
    @Override
    public String getInfo() {
        return "Крестьянин - ";
    }
}
