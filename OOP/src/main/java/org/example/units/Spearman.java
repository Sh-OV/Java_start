package org.example.units;

public class Spearman extends Infantry {

    public Spearman() {

        super(45, 6, 18, 6, new int[]{8,12}, 1, 20);
    }
    @Override
    public String getInfo() {
        return "Копейщик - ";
    }
}
