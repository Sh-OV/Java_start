package org.example.units;

import java.util.ArrayList;


public class Peasant extends BaseHero {
    public Peasant(Vector2D coords, int team) {
        super(2, 50,8, 5, 3, 15,30, team, coords.posX, coords.posY);
    }

    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> ally) {
    }
    @Override
    public String getInfo() {
        return "Фермер - ";
    }
}
