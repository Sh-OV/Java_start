package com.mygdx.game.example.units;

import java.util.ArrayList;

public class Outlaw extends Infantry {


    public Outlaw(Vector2D coords) {

        super(8, 40, 6, 20, 8, 8,12, 2, coords.posX, coords.posY,30);
    }
    @Override
    public String getInfo() {
        return "Разбойник - ";
    }
    }
