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
package org.example;

import org.example.units.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Main {
    public static int num = 10;
    public static ArrayList<BaseHero> hero_light = new ArrayList<>();
    public static ArrayList<BaseHero> hero_darkness = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < num; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    hero_light.add(new Magician());
                    break;
                case 1:
                    hero_light.add(new Spearman());
                    break;
                case 2:
                    hero_light.add(new Crossbowman());
                    break;
                default:
                    hero_light.add(new Peasant(1));
                    break;
            }
        }

        for (int i = 0; i < num; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    hero_darkness.add(new Monk());
                    break;
                case 1:
                    hero_darkness.add(new Outlaw());
                    break;
                case 2:
                    hero_darkness.add(new Sniper());
                    break;
                default:
                    hero_darkness.add(new Peasant(2));
                    break;
            }
        }
        PriorityQueue<BaseHero> sorted_hero = getSortedList();

        System.out.println("\n------Команда hero_darkness:------");
        hero_darkness.forEach(n -> System.out.println(n.toString()));

        System.out.println("\n------Команда hero_light:------");
        hero_light.forEach(n -> System.out.println(n.toString()));

        System.out.println("-".repeat(30));
        System.out.println(hero_darkness.get(5).find_closest_enemy(hero_light));
        System.out.println("-".repeat(30));

        System.out.println("\n------Очередность ходов:------");
        while (!sorted_hero.isEmpty()) {
            System.out.println(sorted_hero.poll().toString());
        }
    }

    public static PriorityQueue<BaseHero> getSortedList() {
        PriorityQueue<BaseHero> sortedList = new PriorityQueue<>(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero o1, BaseHero o2) {
                if (o1.initiative == o2.initiative) return o1.getHp() - o2.getHp();
                return o2.initiative - o1.initiative;
            }
        });
        sortedList.addAll(hero_light);
        sortedList.addAll(hero_darkness);
        return sortedList;
    }
}