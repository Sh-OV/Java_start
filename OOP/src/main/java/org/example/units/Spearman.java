package org.example.units;

public class Spearman extends Infantry {

    public Spearman() {

        super(8, 45, 6, 20, 6, new int[]{8,12}, 1, "stand", 20);
    }
    @Override
    public String getInfo() {
        return "Копейщик - ";
    }
}
