package org.example.units;

public class Spearman extends Infantry {

    public Spearman(Vector2D coords) {

        super(8, 45, 6, 20, 6, 8,12, 1, coords.posX, coords.posY, 20);
    }
    @Override
    public String getInfo() {
        return "Копейщик - ";
    }
}
