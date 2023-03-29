package org.example.units;

import java.util.ArrayList;
import java.util.HashMap;

public class Magician extends BaseHero {
    protected int manna;
    protected HashMap<String, ArrayList<String>> book_spells;

    public Magician(String name, int x, int y) {
        super(name, x, y, 80, 4, 20, 10, new int[]{5,10}, true);
        this.manna = 70;
        this.book_spells = new HashMap<>();
    }
}
