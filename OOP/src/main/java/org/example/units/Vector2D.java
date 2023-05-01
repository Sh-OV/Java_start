package org.example.units;

public class Vector2D {
    protected int posX;
    protected int posY;


    public Vector2D(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    protected double getDistance(Vector2D oponent){
        return Math.sqrt(Math.pow(posX - oponent.posX,2) + Math.pow(posY - oponent.posY,2));
    }

    protected void getCoord_move (Vector2D enemy, Vector2D ally){
        int move_x = enemy.posX - posX;
        int move_y = enemy.posY - posY;
        if (Math.abs(move_x) > Math.abs(move_y))
            posX += Math.signum(move_x);
        else posY += Math.signum(move_y);
       // if (Math.abs(move_x) < 2 || Math.abs(move_y) < 2)
    }



    protected int isLeft_X(Vector2D oponent){
        System.out.println("Math.abs(this.posX - oponent.posX) = " + Math.abs(this.posX - oponent.posX));
        if (Math.abs(this.posX - oponent.posX) >= 2) {
            if (this.posX < oponent.posX) return 1;
            else return 0;
        }
        else return 2;
    }
    protected int isLeft_Y(Vector2D oponent){
        System.out.println("Math.abs(this.posY - oponent.posY) = " + Math.abs(this.posY - oponent.posY));
        if (Math.abs(this.posY - oponent.posY) >= 2) {
            if (this.posY < oponent.posY) return 1;
            else return 0;
        }
        else return 2;
    }
    protected boolean isLeft(Vector2D oponent){
        if(Math.abs(this.posX - oponent.posX) > Math.abs(this.posY - oponent.posY)) {
            return false;
        }
        else return true;
    }




}
