package org.example.units;

import java.util.ArrayList;
import java.util.HashMap;

public class Monk extends Mag {

    public Monk() {

        super(5, 70, 4, 20, 10, new int[]{5,10}, 2, 80, new HashMap<>());
    }
    @Override
    public String getInfo() {
        return "Монах - ";
    }
}