package org.example.units;

import java.util.ArrayList;
import java.util.HashMap;

public class Monk extends Mag {

    public Monk(Vector2D coords) {

        super(5, 70, 4, 10, 10, 5,10, 2,  coords.posX, coords.posY,
              80, new String[]{"lightning", "slowly", "speed", "resurrect", "shield"});
    }
    @Override
    public String getInfo() {
        return "Волшебник - ";
    }
}