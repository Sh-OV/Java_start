/*
Урок 5. Хранение и обработка данных ч2: множество коллекций Map
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов. Пусть дан список сотрудников.
Напишите программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности имён.
*Популярность не имён а номеров телефонов
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Hw5 {
    static ArrayList<String> user = new ArrayList<>();
    static ArrayList<String> number_phone = new ArrayList<>();
    static Scanner user_scan = new Scanner(System.in);
    static HashMap<String, ArrayList<String>> users_contacts = new HashMap<>();

    public static void main(String[] args) {
        user_data(users_contacts);
        users_contacts.forEach((k, v) -> System.out.println(k + ", " + v));
        System.out.println("=".repeat(30));
        sorting_popular(users_contacts);
    }

    private static void user_data(HashMap<String, ArrayList<String>> uc) {
        String consol;
        System.out.println("Введите 'д' для ввода новой записи и любую клавишу для завершения ввода данных: ");
        consol = user_scan.nextLine();
        int i = 0;
        while (consol.equals("д")) {
            ArrayList<String> n = new ArrayList<>();
            System.out.println("Контактное лицо: ");      // т.к. подключен файл из которого берутся данные, ввод из консоли неактуален
            String user = user_scan.nextLine();
            System.out.println("Номер домашнего телефона: ");
            String number_phone = user_scan.nextLine();
            n.add(number_phone);
            System.out.println("Номер рабочего телефона: ");
            number_phone = user_scan.nextLine();
            n.add(number_phone);
            System.out.println("Номер личного телефона: ");
            number_phone = user_scan.nextLine();
            n.add(number_phone);
            uc.put(user, n);
            System.out.println("Введите 'д' для ввода новой записи и любую клавишу для завершения ввода данных: ");
            consol = user_scan.nextLine();
        }
    }
    public static void sorting_popular(HashMap<String, ArrayList<String>> hms){
        TreeMap<String, ArrayList<String>> t_map = new TreeMap<>();
        hms.forEach((k,v) -> t_map.put(k,v));
        t_map.forEach((k, v) -> System.out.println(k + ", " + v));
    }
}
