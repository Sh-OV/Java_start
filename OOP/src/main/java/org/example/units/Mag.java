package org.example.units;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Mag extends BaseHero{
    protected int manna;
    protected HashMap<String, ArrayList<String>> book_spells;
    public Mag(int x, int y, float hp, int step, int attack, int def, int[] damage,
               int manna, HashMap<String, ArrayList<String>> book_spells) {
        super(x, y, hp, step, attack, def, damage);
        this.manna = manna;
        this.book_spells = book_spells;
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return null;
    }
}