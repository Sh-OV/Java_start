package org.example.units;

import java.util.ArrayList;

public interface GameInterface {
    void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> ally);
    String getInfo();
}
