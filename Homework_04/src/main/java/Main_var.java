/*
 Урок 4. Хранение и обработка данных ч1: приоритетные коллекции
1. Ввод с консоли в формате Ф.И.О Возраст пол
2. Выход из режима вода по горячей кнопке
3. Вывод несортированного списка в формате Иванов И.И. 32M
4. Два варианта продолжения, либо вывод списка сортированного по возрасту и полу либо завершение приложения.
Реализовать сортировку, по возможности, с использованием дополнительного индексного списка.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;

public class Main_var {

    static LinkedList<ArrayList<String>> contact_users = new LinkedList<>();
    static Scanner user_scan = new Scanner(System.in);

    static LinkedList<Integer> id = new LinkedList<>();
    static int i = 1;
    static HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();

    public static void main(String[] args) {
        data_entry_conditions(contact_users);
        hash_map_users(contact_users, id, hashMap);
        hashMap.forEach((k, v) -> System.out.println(k + ". " + v));
        print_user(contact_users, id, hashMap);
        hashMap.forEach((k, v) -> System.out.println(k + ". " + v));
    }

    private static ArrayList<String> user_data_entry() {
        id.add(i++);
        ArrayList<String> user = new ArrayList<>();
        System.out.println("Введите Фамилию: ");      // т.к. подключен файл из которого берутся данные, ввод из консоли неактуален
        String last_name = user_scan.nextLine();
        user.add(last_name);
        System.out.println("Введите Имя: ");
        String first_name = user_scan.nextLine();
        user.add(first_name);
        System.out.println("Введите Отчество: ");
        String patronymic = user_scan.nextLine();
        user.add(patronymic);
        System.out.println("Введите возраст: ");
        String age = user_scan.nextLine();
        user.add(age);
        System.out.println("Введите пол: ");
        String gender = user_scan.nextLine();
        user.add(gender);
        return user;
    }

    private static void hash_map_users(LinkedList<ArrayList<String>> lls,
                                       LinkedList<Integer> lli,
                                       HashMap<Integer, ArrayList<String>> hm) {
        for (int j = 0; j < lls.size(); j++) {
            hm.put(lli.get(j), lls.get(j));
        }
    }

    private static void print_user(LinkedList<ArrayList<String>> lls,
                                   LinkedList<Integer> lli,
                                   HashMap<Integer, ArrayList<String>> hm) {
        for (int j = 0; j < hm.size(); j++) {
            ArrayList<String> help = new ArrayList<>();
            help.add(lls.get(j).get(0) + " " +
                    lls.get(j).get(1).toUpperCase().charAt(0) + "." +
                    lls.get(j).get(2).toUpperCase().charAt(0) + ". " +
                    lls.get(j).get(3) + " " +
                    lls.get(j).get(4));
            hm.put(lli.get(j), help);


       /*
            System.out.print(lli.get(j) + ". " +
                    lls.get(j).get(0) + " " +
                    lls.get(j).get(1).toUpperCase().charAt(0) + "." +
                    lls.get(j).get(2).toUpperCase().charAt(0) + ". " +
                    lls.get(j).get(3) + " " +
                    lls.get(j).get(4) + "\n");*/
        }
    }

    private static void data_entry_conditions(LinkedList<ArrayList<String>> lls) {
        String command;
        System.out.println("Введите 'д' для ввода новой записи и любую клавишу для завершения ввода данных: ");
        command = user_scan.nextLine();
        while (command.equals("д")) {
            lls.add(user_data_entry());
            System.out.println("Введите 'д' для ввода новой записи и любую клавишу для завершения ввода данных: ");
            command = user_scan.nextLine();
        }
    }

    public static void sorting_index(LinkedList<ArrayList<String>> lls, int arg) {
        Comparator<ArrayList<String>> sorting = new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                if (o1.get(arg).charAt(0) > o2.get(arg).charAt(0)) return 1;
                else if (o1.get(arg).charAt(0) < o2.get(arg).charAt(0)) return -1;
                else return 0;
            }
        };
        lls.sort(sorting);
    }

}
