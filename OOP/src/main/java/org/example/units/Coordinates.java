package org.example.units;


import org.example.Main;

import java.util.ArrayList;

public class Coordinates {
    protected static int count = Main.num - 1;
    protected static int x;
    protected static int y;

    public Coordinates() {

    }

    public static Integer start_coord_X() {
        if (BaseHero.team == 2) {
            x = 0;
        } else if (BaseHero.team == 1) {
            x = Main.num - 1;
        }
        return x;
    }

    public static Integer start_coord_Y() {
        if (count < 0) {
            count = Main.num - 1;
        }
        y = count;
        count--;
        return y;
    }

    public static Integer coord_X_step() {
        return x;
    }

    public static Integer coord_Y_step() {
        return y;
    }

}