package org.example.units;

import org.example.Main;

import java.util.ArrayList;
import java.util.Random;


public abstract class BaseHero implements GameInterface {
    protected static int start_coord_x1 = 0;
    protected static int start_coord_y1;
    protected static int start_coord_x2 = Main.num-1;
    protected static int start_coord_y2;
    protected String       name;        // Имя игрока-персонажа
    protected int       x, y;           // Координаты
    public int initiative;           // Инициатива
    protected float     hp, max_hp;     // Здоровье
    protected int       step,           // Шаг (количество клеток)
                        attack,         // Атака
                        def;            // Защита
    protected int[]     damage;         // минимальный и максимальный ущерб
    public int team;                    // к какой команде относится
    protected String stat = "stand";            // состояние в бою (стоит, мертв, занят) + спрятался - для разбойников

    public BaseHero(int initiative, float hp, int step, int attack, int def, int[] damage, int team, String stat) {
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
        this.stat = stat;
    }
    private static String getName(){        // метод случайного заполнения именами перснажей
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }
    @Override
    public String toString(){
        return (getInfo() + name + " , " + x + " , " + y + ", init = " + initiative + ", hp = " + getHp() + ", stat: " + stat);
    }

   public BaseHero find_closest_enemy(ArrayList<BaseHero> enemy_team){      // метод поиска ближайшего противника
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
   public int getHp(){                             // метод получения остатка здоровья персонажа
        return (int) ((float) this.hp / (float) this.max_hp * 100);
   }

   public void accessing_hp_enemy(BaseHero pers) {  // метод обращения к параметрам противника и изменение их
       pers.hp -= this.attack - pers.def;
   }

   public void accessing_stat_ally(BaseHero pers, String[] arr, int n) {   // изменение статуса у персонажа
       pers.stat = arr[n];
   }

   public void accessing_hp_ally(BaseHero pers, int ratio){                // метод для лечения / воскрешения
        pers.hp *= ratio;
   }
}


