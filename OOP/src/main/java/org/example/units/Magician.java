package org.example.units;

import java.util.ArrayList;
import java.util.HashMap;

public class Magician extends Mag {

    public Magician() {
        super(5, 80, 4, 20, 10, new int[]{5, 10}, 1, new String[]{"stand", "dead", "busy"},
              70, new String[]{"lightning", "slowly", "speed", "heal all", "shield"});

    }

    @Override
    public String getInfo() {
        return "Маг - ";
    }
}
