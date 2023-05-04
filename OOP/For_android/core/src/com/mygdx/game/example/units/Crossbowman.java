package com.mygdx.game.example.units;

public class Crossbowman extends Shooter {


    public Crossbowman(Vector2D coords) {
        super(10, 30, 3, 15, 6, 10, 20, 1, coords.posX, coords.posY,10, 70);

    }

    @Override
    public String getInfo() {
        return "Арбалетчик - ";
    }
}
