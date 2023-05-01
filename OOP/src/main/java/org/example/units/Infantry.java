package org.example.units;

import org.example.View;

import java.util.ArrayList;

public abstract class Infantry extends BaseHero{
    protected  int gian;     // увеличение удара при разбеге
    public Infantry(int initiative, float hp, int step, int attack, int def, int damageMin, int damageMax, int team, int posX, int posY,
                    int gian) {
        super(initiative, hp, step, attack, def, damageMin, damageMax, team, posX, posY);
        this.gian = gian;
    }

    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> ally) {
        if(hp <= 0){
            this.condition = "Dead";
            return;
        }
        BaseHero enemy_pers = ally.get(find_closest_enemy(enemy));
        BaseHero ally_pers = ally.get(find_closest_ally(ally));
        getCoord_move(enemy_pers);

//        walking (enemy_pers, ally_pers);
        System.out.println(this.toString() + " идёт атаковать " + enemy_pers.toString());

    }
    protected void getCoord_move (BaseHero enemy){
        System.out.println("X = " + coords.posX + ", Y = " + coords.posY);
        int move_x = coords.posX - enemy.coords.posX;
        int move_y = coords.posY - enemy.coords.posY;
        System.out.println("Math.abs(move_x) = " + Math.abs(move_x) + ", Math.abs(move_y) = " + Math.abs(move_y));
        if (Math.abs(move_x) > Math.abs(move_y)){
            coords.posX = (int) Math.signum(move_x);
            coords.posY = (int) Math.signum(move_y);
            System.out.println("Xism = " + coords.posX + ", Yism = " + coords.posY);
        }
        else {
            coords.posX = (int) Math.signum(move_x);
            coords.posY = (int) Math.signum(move_y);
            System.out.println("Xism = " + coords.posX + ", Yism = " + coords.posY);
        }
    }





    public void walking (BaseHero enemy, BaseHero ally){
        System.out.println("coords.isLeft(enemy.coords) = " + coords.isLeft(enemy.coords) + "\n" +
                        "coords.isLeft_X(enemy.coords) = " + coords.isLeft_X(enemy.coords) +"\n" +
                        "coords.isLeft_Y(enemy.coords) = " + coords.isLeft_Y(enemy.coords) +" \n" +
                        "coords.isLeft_X(ally.coords) = " + coords.isLeft_X(ally.coords)+"\n" +
                        "coords.isLeft_Y(ally.coords) = " + coords.isLeft_Y(ally.coords) + "\n" +
                "this.getCoords()[0] = " + this.getCoords()[0] + "\n" +
                "this.getCoords()[1] = " + this.getCoords()[1]);
        if(coords.isLeft(enemy.coords) && (coords.isLeft_X(ally.coords) != 2 && coords.isLeft_Y(ally.coords) != 2)){
            if (coords.isLeft_X(enemy.coords) == 1){
                this.getCoords()[0] += step;
                this.condition = "Go";
                System.out.println("Ход " + getInfo() + name + "this.coords.posX+ = " + this.coords.posX);
            }
            else if (coords.isLeft_X(enemy.coords) == 0){
                this.getCoords()[0] -= 1;
                this.condition = "Go";
                System.out.println("Ход " + getInfo() + name + "this.coords.posX- = " + this.coords.posX);
            }
            else accessing_hp_enemy(enemy);
        }
        else if(!coords.isLeft(enemy.coords) && (coords.isLeft_X(ally.coords) != 2 && coords.isLeft_Y(ally.coords) != 2)){
            if (coords.isLeft_Y(enemy.coords) == 1){
                this.getCoords()[1] += 1;
                this.condition = "Go";
                System.out.println("Ход " + getInfo() + name + "this.coords.posY+ = " + this.coords.posX);
            }
            else if (coords.isLeft_Y(enemy.coords) == 0){
                this.getCoords()[1] -= 1;
                this.condition = "Go";
                System.out.println("Ход " + getInfo() + name + "this.coords.posY- = " + this.coords.posX);
            }
            else accessing_hp_enemy(enemy);
            this.condition = "Stand";
        }
        System.out.println("Ошибка в методе walking (BaseHero enemy, BaseHero ally)");
    }

}
