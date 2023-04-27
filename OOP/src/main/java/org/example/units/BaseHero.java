package org.example.units;

import org.example.Main;

import java.util.ArrayList;
import java.util.Random;


public abstract class BaseHero implements GameInterface {
    protected String        name;                   // Имя игрока-персонажа
    protected Vector2D      coords;                 // Координаты
    public int              initiative;             // Инициатива
    protected float         hp, max_hp;             // Здоровье
    protected int           step,                   // Шаг (количество клеток)
                            attack,                 // Атака
                            def;                    // Защита
    protected int           damageMin, damageMax;   // минимальный и максимальный ущерб
    public int              team;                   // к какой команде относится
    protected String        condition = "stand";    // состояние в бою (стоит, мертв, занят) + спрятался - для разбойников
    public int[] getCoords() {return new int[]{coords.posX, coords.posY};}
    public BaseHero(int initiative, float hp, int step, int attack, int def, int damageMin, int damageMax, int team, int posX, int posY) {
        this.name = getName();
        this.initiative = initiative;
        this.hp = hp;
        this.max_hp = hp;
        this.step = step;
        this.attack = attack;
        this.def = def;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.team = team;
        this.condition = "Stand";
        coords = new Vector2D(posX, posY);
    }
    private static String getName(){        // метод случайного заполнения именами перснажей
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }
    @Override

        public String toString() {
            return getInfo() + name +
                    " H:" + Math.round(hp) +
                    " D:" + def +
                    " A:" + attack +
                    " Dmg:" + Math.round(Math.abs((damageMin + damageMax)/2)) +
                    " " + condition;
        }
/*
int index = 0;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < team.size(); i++) {
            if(min > coords.getDistance(team.get(i).coords) && !team.get(i).state.equals("Die")) {
                index = i;
                min = coords.getDistance(team.get(i).coords);
            }
        }
 */

   public int find_closest_enemy(ArrayList<BaseHero> enemy_team){      // метод поиска ближайшего противника
       int index = 0;
       double min = Double.MAX_VALUE;
       for (int i = 0; i < enemy_team.size(); i++) {
           if(min > coords.getDistance(enemy_team.get(i).coords) && enemy_team.get(i).hp > 0) {
               index = i;
               min = coords.getDistance(enemy_team.get(i).coords);
           }
       }
       return index;
   }
   public int getHp(){                             // метод получения остатка здоровья персонажа
        return (int) ((float) this.hp / (float) this.max_hp * 100);
   }

   public void accessing_hp_enemy(BaseHero pers) {  // метод обращения к параметрам противника и изменение их
       pers.hp -= this.attack - pers.def;
   }

   public void accessing_stat_ally(BaseHero pers, String[] arr, int n) {   // изменение статуса у персонажа
       pers.condition = arr[n];
   }

   public void accessing_hp_ally(BaseHero pers, int ratio){                // метод для лечения / воскрешения
        pers.hp *= ratio;
   }

}


