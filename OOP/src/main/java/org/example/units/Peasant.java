package org.example.units;

public class Peasant extends BaseHero {
    public Peasant(String name, int x, int y, boolean command) {
        super(name, x, y, 50, 8, 5, 3, new int[]{15,30}, command);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return null;
    }
}
