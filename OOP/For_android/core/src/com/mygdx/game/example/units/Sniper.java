package com.mygdx.game.example.units;

public class Sniper extends Shooter {
      public Sniper(Vector2D coords) {
        super(10, 35, 3, 15, 5, 10, 20, 2, coords.posX, coords.posY,9, 80);

    }
    @Override
    public String getInfo() {
        return "Снайпер - ";
    }
}