package org.example.units;

public class Vector2D {
    protected int posX;
    protected int posY;

    public Vector2D(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
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

    protected double getDistance(Vector2D oponent){
        return Math.sqrt(Math.pow(posX - oponent.posX,2) + Math.pow(posY - oponent.posY,2));
    }


}
