package org.example.units;

import java.util.ArrayList;
import java.util.HashMap;

public class Monk extends BaseHero {
    protected int manna;
    protected HashMap<String, ArrayList<String>> book_spells;

    public Monk(String name, int x, int y) {
        super(name, x, y, 70, 4, 20, 10, new int[]{5,10}, false);
        this.manna =80;
        this.book_spells = new HashMap<>();
    }
}