package com.mygdx.game.example.units;

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
    protected String        condition;              // состояние в бою (стоит, мертв, занят) + спрятался - для разбойников
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
        this.condition = " \uD83C\uDF1D Stand";
        coords = new Vector2D(posX, posY);
    }
    private static String getName(){        // метод случайного заполнения именами перснажей
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }
    @Override

        public String toString() {
            return getInfo() + name +
                    " x=" + coords.posX +
                    " y=" + coords.posY +
                    " ❤" + getHp() +
                    " ⛨" + def +
                     " \uD83D\uDDE1"+ attack +
                    " \uD83E\uDE83" + Math.round(Math.abs((damageMin + damageMax)/2)) +
                    " " + condition;
        }

  public int find_closest_ally(ArrayList<BaseHero> hero){      // метод поиска ближайшего союзника
       int index = 0;
       double min = Double.MAX_VALUE;
       for (int i = 0; i < hero.size(); i++) {
           if(min > coords.getDistance(hero.get(i).coords) && coords.getDistance(hero.get(i).coords) >= 1 && hero.get(i).hp > 0) {
               index = i;
               min = coords.getDistance(hero.get(i).coords);
           }
       }
       return index;
   }


   public int find_closest_enemy(ArrayList<BaseHero> hero){      // метод поиска ближайшего противника
       int index = 0;
       double min = Double.MAX_VALUE;
       for (int i = 0; i < hero.size(); i++) {
           if(min > coords.getDistance(hero.get(i).coords) && hero.get(i).hp > 0) {
               index = i;
               min = coords.getDistance(hero.get(i).coords);
           }
       }
       return index;
   }
   public int getHp(){                             // метод получения остатка здоровья персонажа
        return (int) ((float) this.hp / (float) this.max_hp * 100);
   }

   public void accessing_hp_enemy(BaseHero pers) {  // метод изменения здоровья противника после удара
       float damage = (pers.def - attack)>0 ? damageMin : (pers.def - attack)<0 ? damageMax : (float) (damageMin + damageMax)/2;
       pers.hp -= damage;
   }

}


