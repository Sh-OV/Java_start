package org.example.units;

import java.util.ArrayList;
import java.util.HashMap;

public class Monk extends Mag {

    public Monk(String name, int x, int y) {
        super(name, x, y, 70, 4, 20, 10, new int[]{5,10}, false, 80, new HashMap<>());
    }
}