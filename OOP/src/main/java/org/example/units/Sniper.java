package org.example.units;

public class Sniper extends Shooter {
      public Sniper() {
        super(10, 35, 3, 15, 5, new int[]{10, 20}, 2, new String[]{"stand", "dead", "busy"},9, 80);

    }
    @Override
    public String getInfo() {
        return "Снайпер - ";
    }
}