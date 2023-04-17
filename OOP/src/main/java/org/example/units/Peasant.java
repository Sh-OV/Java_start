package org.example.units;

import java.util.ArrayList;
import java.util.Random;

public class Peasant extends BaseHero {
    public Peasant(int team) {
        super(1, 1, 50,8, 5, 3, new int[]{15,30}, team);
    }

    @Override
    public void step(ArrayList<BaseHero> enemy_team) {

    }
    @Override
    public String getInfo() {
        return "Крестьянин - ";
    }
}
