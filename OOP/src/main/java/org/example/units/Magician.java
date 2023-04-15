package org.example.units;

import java.util.ArrayList;
import java.util.HashMap;

public class Magician extends Mag {

    public Magician() {
        super(1, 1, 80, 4, 20, 10, new int[]{5, 10}, 70, new HashMap<>());

    }

    @Override
    public String getInfo() {
        return "Маг - " + name;
    }
}
