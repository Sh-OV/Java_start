/*
Урок 5. Хранение и обработка данных ч2: множество коллекций Map
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов. Пусть дан список сотрудников.
Напишите программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности имён.
*Популярность не имён а номеров телефонов
 */

import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.util.*;

public class Main {
    static HashMap<String, String> users_contacts = new HashMap<>();
    static HashMap<String, Integer> popular = new HashMap<>();
    static Scanner user_scan = new Scanner(System.in);
    static Set<String> keys = users_contacts.keySet();

    public static void main(String[] args) {

        user_data(users_contacts);
        users_contacts.forEach((k, v) -> System.out.println(v + ", " + k));
        System.out.println("=".repeat(30));

        popular_rand(making_changes(keys, users_contacts), popular);
        popular.forEach((k, v) -> System.out.println(k + ", " + v));

        System.out.println("=".repeat(30));
        sorting_popular(popular);
        popular.forEach((k, v) -> System.out.println(k + ", " + v));
        /*System.out.println("=".repeat(30));
        System.out.println(users_contacts.keySet());
        System.out.println("=".repeat(30));
        System.out.println(users_contacts.values());
        System.out.println("=".repeat(30));
        System.out.println(users_contacts.entrySet());*/
    }

    private static void user_data(HashMap<String, String> hm) {
        String consol;
        System.out.println("Введите 'д' для ввода новой записи и любую клавишу для завершения ввода данных: ");
        consol = user_scan.nextLine();
        while (consol.equals("д")) {
            System.out.println("Контактное лицо: ");      // т.к. подключен файл из которого берутся данные, ввод из консоли неактуален
            String user = user_scan.nextLine();
            System.out.println("Номер телефона (11 цифр): ");
            String number_phone = user_scan.nextLine();
            hm.putIfAbsent(number_phone, user);
            System.out.println("Введите 'д' для ввода новой записи и любую клавишу для завершения ввода данных: ");
            consol = user_scan.nextLine();
        }
    }

    private static ArrayList<String> making_changes(Set<String> ss, HashMap<String, String> hm) {
        Iterator<String> it = ss.iterator();
        ArrayList<String> keys_arr = new ArrayList<>();
        hm.forEach((k, v) -> keys_arr.add(k));
        return keys_arr;
    }

    public static void popular_rand(ArrayList<String> l, HashMap<String, Integer> hm) {
        for (int j = 0; j < l.size(); j++) {
            hm.put( l.get(j), new Random().nextInt(55));
        }
    }
    public static void sorting_popular(HashMap<String, Integer> hm, Set<String> k) {
        Comparator<HashMap<String, Integer>> sorting = new Comparator<HashMap<String, Integer>>() {
            @Override
            public int compare(HashMap<String, Integer> o1, HashMap<String, Integer> o2) {
                for (int i = 0; i < hm.size(); i++) {
                    if (o1.get(i) > o2.get(i)) return -1;
                    else if (o1.get(i) < o2.get(i)) return 1;
                    else return 0;

                }
            };


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



