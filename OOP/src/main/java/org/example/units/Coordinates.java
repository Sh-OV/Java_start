package org.example.units;


import org.example.Main;

public class Coordinates {
    protected static int count = Main.num-1;
    protected static int x = 0;
    protected static int y = 0;
    protected int x1;
    protected int x2;
    protected int y1;
    protected int y2;

       protected float distance;

    public Coordinates(int x, int y, float distance) {

        this.distance = distance;
    }

    public static Integer start_coord_X(){
        if (BaseHero.team == 2){
            x = 0;
        }
        else if (BaseHero.team == 1) {
            x = Main.num-1;
        }
        return x;
    }
    public static Integer start_coord_Y(){
        if (count < 0){
            count = Main.num-1;
        }
        y = count;
        count--;
        return y;
    }
    public static Integer coord_X_step(){
        return x;
    }
    public static Integer coord_Y_step(){
        return y;
    }

    private float dist(){
        distance = (x2 - x1)^2 + (y2-y1)^2;
        return distance;
    }
}
