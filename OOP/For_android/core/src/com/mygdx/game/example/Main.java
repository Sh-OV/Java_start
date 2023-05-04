/*
Урок 1. Принципы ООП: Инкапсуляция, наследование, полиморфизм
Проанализировать и описать персонажей:
Маг         - Имя, Координаты, Здоровье, Количество шагов, Сила, Защита, Команда 1, Количество манны, Книга заклинания, Воскрешает один класс воинов одним заклинанием - относится к книге заклинаний,
              Атаковать, Сделать ход, Обороняться в ближнем бою
монах       - Имя, Координаты, Здоровье, Количество шагов, Сила, Защита, Команда 2, Количество манны, Книга заклинания, Лечит весь отряд одним заклинанием - относится к книге заклинаний,
              Атаковать, Сделать ход, Обороняться в ближнем бою
копейщик    - Имя, Координаты, Здоровье, Количество шагов, Сила, Защита, Команда 1, Меткость от разбега, Иногда двойной удар,
              Атаковать, Сделать ход, Обороняться в ближнем бою
разбойник   - Имя, Координаты, Здоровье, Количество шагов, Сила, Защита, Команда 2, Меткость от разбега, подбегает бъет и возвращается на место,
              Атаковать, Сделать ход, Обороняться в ближнем бою
арбалетчик  - Имя, Координаты, Здоровье, Количество шагов, Сила, Защита, Команда 1, Меткость от расстояния, Количество стрел, Иногда двойной удар,
              Атаковать, Сделать ход, Обороняться в ближнем бою
снайпер     - Имя, Координаты, Здоровье, Количество шагов, Сила, Защита, Команда 2, Меткость от расстояния, Количество стрел, Иногда прямой удар на любом расстоянии,
              Атаковать, Сделать ход, Обороняться в ближнем бою
крестьянин  - Имя, Координаты, Здоровье, Количество шагов, Сила, Защита,  Команда 1 или 2, Вес груза,
              Взять боеприпасы, Отдать боеприпасы
На базе описания персонажей описать простейшую иерархию классов.
В основной программе создать по одному экземпляру каждого класса.
Общие свойтства для всех персонажей:
Здоровье
Количество шагов
Оружие
Количество боеприпасов

 */
package com.mygdx.game.example;

import com.mygdx.game.example.units.*;

import java.util.*;


public class Main {
    public static int UNITS = 10;
    public static ArrayList<BaseHero> hero_light = new ArrayList<>();
    public static ArrayList<BaseHero> hero_darkness = new ArrayList<>();
    public static ArrayList<BaseHero> sorted_hero = new ArrayList<>();
    public static void main(String[] args) {
        team_1(hero_light);
        team_2(hero_darkness);
        System.out.println(SpellBook.ressurect.getCost());
        System.out.println(SpellBook.ressurect.getPower());

        Scanner input = new Scanner(System.in);
       while (true){
            sorted_hero =  getSortedList();
            View.view();  // отображение в консоль
           input.nextLine();
            for (BaseHero human: sorted_hero) {
                if (hero_light.contains(human)) human.step(hero_darkness, hero_light);
                else human.step(hero_light, hero_darkness);
            }
        }

/*        System.out.println("\n------Команда hero_darkness:------");
        hero_darkness.forEach(n -> System.out.println(n.toString()));

        System.out.println("\n------Команда hero_light:------");
        hero_light.forEach(n -> System.out.println(n.toString()));

        System.out.println("-".repeat(30));
        for (BaseHero hero:hero_darkness) {
            hero.step(hero_light,hero_darkness);
        }
        for (BaseHero hero:hero_light) {
            hero.step(hero_darkness, hero_light);
        }
        System.out.println("-".repeat(30));

        System.out.println("\n------Очередность ходов:------");
        sorted_hero.forEach(n -> System.out.println(n.toString()));*/
        }
    private static ArrayList<BaseHero> team_1(ArrayList<BaseHero> hero){
        for (int i = 0; i < UNITS; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    hero.add(new Magician(new Vector2D(i+1, 1)));
                    break;
                case 1:
                    hero.add(new Spearman(new Vector2D(i+1, 1)));
                    break;
                case 2:
                    hero.add(new Crossbowman(new Vector2D(i+1, 1)));
                    break;
                default:
                    hero.add(new Peasant(new Vector2D(i+1, 1), 1));
                    break;
            }
        }
        return hero;
    }
    private static ArrayList<BaseHero> team_2(ArrayList<BaseHero> hero){
        for (int i = 0; i < UNITS; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    hero.add(new Monk(new Vector2D(i+1, UNITS)));
                    break;
                case 1:
                    hero.add(new Outlaw(new Vector2D(i+1, UNITS)));
                    break;
                case 2:
                    hero.add(new Sniper(new Vector2D(i+1, UNITS)));
                    break;
                default:
                    hero.add(new Peasant(new Vector2D(i+1, UNITS), 2));
                    break;
            }
        }
        return hero;
    }
    private static ArrayList<BaseHero> getSortedList() {
        ArrayList<BaseHero> sortedList = new ArrayList<>();
        sortedList.addAll(hero_light);
        sortedList.addAll(hero_darkness);
        sortedList.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero t0, BaseHero t1) {
                if (t1.initiative == t0.initiative) return t1.getHp() - t0.getHp();
                else  return t1.initiative - t0.initiative;
            }
        });

        return sortedList;
    }
}