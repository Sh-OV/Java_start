package org.example.units;

import java.util.ArrayList;
import java.util.Random;


public abstract class BaseHero implements GameInterface {
    protected static int start_coord_x1 = 0;
    protected static int start_coord_y1;
    protected static int start_coord_x2 = 9;
    protected static int start_coord_y2;

    protected String       name;        // Имя игрока-персонажа
    protected int       x, y;           // Координаты
    protected int initiative;           // Инициатива
    protected float     hp, max_hp;     // Здоровье
    protected int       step,           // Шаг (количество клеток)
                        attack,         // Атака
                        def;            // Защита
    protected int[]     damage;         // минимальный и максимальный ущерб
    public static int team;

    public BaseHero(int initiative, float hp, int step, int attack, int def, int[] damage, int team) {
        this.name = getName();
        if(team == 1){
            this.x = start_coord_x1;
            this.y = start_coord_y1++;
        }
        else if(team == 2){
            this.x = start_coord_x2;
            this.y = start_coord_y2++;
        }
        this.initiative = initiative;
        this.hp = hp;
        this.max_hp = hp;
        this.step = step;
        this.attack = attack;
        this.def = def;
        this.damage = damage;
        this.team = team;
    }
    private static String getName(){

        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }
    @Override
    public String toString(){
        return (getInfo() + name + " , " + x + " , " + y);
    }

   public BaseHero find_closest_enemy(ArrayList<BaseHero> enemy_team){
        BaseHero closest_enemy = enemy_team.get(0);
        double distance = Math.sqrt(Math.pow(enemy_team.get(0).x - this.x, 2) + Math.pow(enemy_team.get(0).y - this.y, 2));
        double min_distance = distance;
        for (BaseHero enemy : enemy_team) {
            if (enemy.hp <= 0) continue;
            distance = Math.sqrt(Math.pow(enemy.x - this.x, 2) + Math.pow(enemy.y - this.y, 2));
            if (min_distance > distance){
                min_distance = distance;
                closest_enemy = enemy;
            }
        }
        return closest_enemy;
    }





}

