/*
Урок 5. Хранение и обработка данных ч2: множество коллекций Map
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов. Пусть дан список сотрудников.
Напишите программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности имён.
*Популярность не имён а номеров телефонов
 */

import java.util.*;

public class Main {
    static HashMap<String, String> users_contacts = new HashMap<>();
    static HashMap<String, Integer> popular = new HashMap<>();
    static Scanner user_scan = new Scanner(System.in);
    static Set<String> keys = users_contacts.keySet();

    public static void main(String[] args) {

        user_data(users_contacts);
        users_contacts.forEach((k, v) -> System.out.println(k + ", " + v));
        System.out.println("=".repeat(30));
        popular_rand(making_changes(users_contacts), popular);
        sorting_popular(popular, users_contacts);
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

    private static ArrayList<String> making_changes(HashMap<String, String> hm) {
        ArrayList<String> keys_arr = new ArrayList<>();
        hm.forEach((k, v) -> keys_arr.add(k +", " + v));
        return keys_arr;
    }

    public static void popular_rand(ArrayList<String> l, HashMap<String, Integer> hm) {
        for (int j = 0; j < l.size(); j++) {
            hm.put(l.get(j), new Random().nextInt(55));
        }
    }
    public static void sorting_popular(HashMap<String, Integer> hmi, HashMap<String, String> hms){
        TreeMap<Integer, String> t_map = new TreeMap<>();
        hmi.forEach((k,v) -> t_map.put(v,k));
        t_map.forEach((k, v) -> System.out.println(k + ", " + v));
    }
}



