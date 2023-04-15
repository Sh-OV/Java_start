package org.example.units;

public class Peasant extends BaseHero {
    public Peasant() {

        super(1,1, 50, 8, 5, 3, new int[]{15,30});
    }

    @Override
    public void step() {

    }
    @Override
    public String getInfo() {
        return "Крестьянин" +
                " - " + name;
    }
}
