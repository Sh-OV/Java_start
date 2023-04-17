package org.example.units;


import org.example.Main;

import java.util.ArrayList;

public class Coordinates {
    protected static int count = Main.num-1;
    protected static int x;
    protected static int y;
    protected int x1;
    protected int x2;
    protected int y1;
    protected int y2;
    protected float distance;

    public Coordinates(int x1, int x2, int y1, int y2, float distance) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.distance = dist();
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
        ArrayList<BaseHero> team_1 = Main.hero_light;
        ArrayList<BaseHero> team_2 = Main.hero_darkness;
        if (BaseHero.team == 1){
            for (BaseHero enemy : team_2) {
                distance = (float) Math.sqrt(Math.pow(enemy.x - x, 2) + Math.pow(enemy.y - y, 2));
            }
        }
        else if (BaseHero.team == 2){
            for (BaseHero enemy : team_1) {
                distance = (float) Math.sqrt(Math.pow(enemy.x - x, 2) + Math.pow(enemy.y - y, 2));
            }
        }
        return distance;
    }
}
