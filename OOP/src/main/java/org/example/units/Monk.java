package org.example.units;

import java.util.ArrayList;
import java.util.HashMap;

public class Monk extends Mag {

    public Monk() {

        super(5, 70, 4, 10, 10, new int[]{5,10}, 2,  "stand",
              80, new String[]{"lightning", "slowly", "speed", "resurrect", "shield"});
    }
    @Override
    public String getInfo() {
        return "Монах - ";
    }
}