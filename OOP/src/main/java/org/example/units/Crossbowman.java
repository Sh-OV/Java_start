package org.example.units;

public class Crossbowman extends Shooter {


    public Crossbowman() {
        super(1, 1, 30, 3, 15, 6, new int[]{10, 20}, 10, 70);

    }

    @Override
    public String getInfo() {
        return "Арбалетчик - " + name;
    }
}
