package org.example.units;

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
        BaseHero enemy_pers = ally.get(find_closest(enemy));
        BaseHero ally_pers = ally.get(find_closest(ally));
        walking (enemy_pers, ally_pers);
        System.out.println(this.toString() + " идёт атаковать " + enemy_pers.toString());

    }

    public void walking (BaseHero enemy, BaseHero ally){
        System.out.println("coords.isLeft(enemy.coords) = " + coords.isLeft(enemy.coords) + "\n" +
                        "coords.isLeft_X(enemy.coords) = " + coords.isLeft_X(enemy.coords) +"\n" +
                        "coords.isLeft_Y(enemy.coords) = " + coords.isLeft_Y(enemy.coords) +" \n" +
                        "coords.isLeft_X(ally.coords) = " + coords.isLeft_X(ally.coords)+"\n" +
                        "coords.isLeft_Y(ally.coords) = " + coords.isLeft_Y(ally.coords));
        if(coords.isLeft(enemy.coords)){ //&& coords.isLeft_X(ally.coords) != 2){
            if (coords.isLeft_X(enemy.coords) == 1){
                this.coords.posX += 1;
                this.condition = "Go";
                System.out.println("Ход " + getInfo() + name + "this.coords.posX+ = " + this.coords.posX);
            }
            else if (coords.isLeft_X(enemy.coords) == 0){
                this.coords.posX -= 1;
                this.condition = "Go";
                System.out.println("Ход " + getInfo() + name + "this.coords.posX- = " + this.coords.posX);
            }
            else accessing_hp_enemy(enemy);
        }
        else if(!coords.isLeft(enemy.coords)){// && coords.isLeft_Y(ally.coords) != 2){
            if (coords.isLeft_Y(enemy.coords) == 1){
                this.coords.posY += 1;
                this.condition = "Go";
                System.out.println("Ход " + getInfo() + name + "this.coords.posY+ = " + this.coords.posX);
            }
            else if (coords.isLeft_Y(enemy.coords) == 0){
                this.coords.posX -= 1;
                this.condition = "Go";
                System.out.println("Ход " + getInfo() + name + "this.coords.posY- = " + this.coords.posX);
            }
            else accessing_hp_enemy(enemy);
            this.condition = "Stand";
        }
  //      System.out.println("Ошибка в методе walking (BaseHero enemy, BaseHero ally)");
    }

}
