package org.example.units;

public class Crossbowman extends Shooter {


    public Crossbowman() {
        super(30, 3, 15, 6, new int[]{10, 20}, 1, 10, 70);

    }

    @Override
    public String getInfo() {
        return "Арбалетчик - ";
    }
}
