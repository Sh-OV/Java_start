package org.example.units;

import java.util.ArrayList;
import java.util.HashMap;

public class Magician extends BaseHero {
    protected int manna;
    protected HashMap<String, ArrayList<String>> book_spells;

    public Magician(String name, int x, int y) {
        super(name, x, y, hp, step, attack, def, damage, command);
        this.manna = manna;
        this.book_spells = book_spells;
    }
}
