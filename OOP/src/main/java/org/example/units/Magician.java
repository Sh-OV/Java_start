package org.example.units;

import java.util.ArrayList;
import java.util.HashMap;

public class Magician extends Mag {

    public Magician(Vector2D coords) {
        super(5, 80, 4, 10, 10, 5, 10, 1, coords.posX, coords.posY,
              70, new String[]{"lightning", "slowly", "speed", "heal all", "shield"});

    }

    @Override
    public String getInfo() {
        return "Маг - ";
    }
}
