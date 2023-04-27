package org.example.units;

public class Vector2D {
    protected int posX;
    protected int posY;

    public Vector2D(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    protected int isLeft_X(Vector2D oponent){
        if (Math.abs(posX - oponent.posX) >= 2) {
            if (posX < oponent.posX) return 1;
            else return 0;
        }
        else return 2;
    }
    protected int isLeft_Y(Vector2D oponent){
        if (Math.abs(posY - oponent.posY) >= 2) {
            if (posY < oponent.posY) return 1;
            else return 0;
        }
        else return 2;
    }
    protected boolean isLeft(Vector2D oponent){
        if(Math.abs(posX - oponent.posX) > Math.abs(posY - oponent.posY)) {
            return false;
        }
        else return true;
    }

    protected double getDistance(Vector2D oponent){
        return Math.sqrt(Math.pow(posX - oponent.posX,2) + Math.pow(posY - oponent.posY,2));
    }


}
