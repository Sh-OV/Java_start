package org.example;

import org.example.units.BaseHero;
import java.util.Collections;

public class View {
    private static int steps = 1;
    private static final int[] l = {0};
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies((Main.UNITS - 1), formatDiv("---b"))) + formatDiv("---c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies((Main.UNITS - 1), formatDiv("---e"))) + formatDiv("---f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies((Main.UNITS - 1), formatDiv("---h"))) + formatDiv("---i");
    private static void tabSetter(int cnt, int max){            // метод расставления элементов на "поле"
        int dif = max - cnt + 3;
        if (dif>0) System.out.printf("%" + dif + "s", ":\t"); else System.out.print(":\t");
    }
    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }
    private static String getChar(int x, int y){
        String out = "|   ";
        for (BaseHero human: Main.sorted_hero) {
            if (human.getCoords()[0] == x && human.getCoords()[1] == y){
                if (human.getHp() <= 0) {
                    out = "| " + (AnsiColors.ANSI_RED + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET) + " ";
                    break;
                }
                if (Main.hero_darkness.contains(human)) out = "| " + (AnsiColors.ANSI_GREEN + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET) + " ";
                if (Main.hero_light.contains(human)) out = "| " + (AnsiColors.ANSI_BLUE + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET) + " ";
                break;
            }
        }
        return out;
    }
    public static void view() {
        if (steps == 1 ){
            System.out.print(AnsiColors.ANSI_RED + "First step" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step:" + steps + AnsiColors.ANSI_RESET);
        }
        steps++;
        Main.sorted_hero.forEach((v) -> l[0] = Math.max(l[0], v.toString().length()));
        System.out.print("_".repeat(l[0]*2));
        System.out.println("");
        System.out.print(top10 + "    ");
        System.out.print("Blue side");
        //for (int i = 0; i < l[0]-9; i++)
        System.out.print(" ".repeat(l[0]-8));
        System.out.println(":\tGreen side");
        for (int i = 1; i < Main.UNITS + 1; i++) {
            System.out.print(getChar(1, i));
        }
        System.out.print("|    ");
        System.out.print(Main.hero_light.get(0));
        tabSetter(Main.hero_light.get(0).toString().length(), l[0]);
        System.out.println(Main.hero_darkness.get(0));
        System.out.println(midl10);

        for (int i = 2; i < Main.UNITS; i++) {
            for (int j = 1; j < Main.UNITS + 1; j++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            System.out.print(Main.hero_light.get(i-1));
            tabSetter(Main.hero_light.get(i-1).toString().length(), l[0]);
            System.out.println(Main.hero_darkness.get(i-1));
            System.out.println(midl10);
        }
        for (int j = 1; j < Main.UNITS + 1; j++) {
            System.out.print(getChar(Main.UNITS, j));
        }
        System.out.print("|    ");
        System.out.print(Main.hero_light.get(Main.UNITS - 1));
        tabSetter(Main.hero_light.get(Main.UNITS - 1).toString().length(), l[0]);
        System.out.println(Main.hero_darkness.get(Main.UNITS - 1));
        System.out.println(bottom10);
    }
}