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
    static Scanner user_scan = new Scanner(System.in);
    static Set<String> keys = users_contacts.keySet();

    public static void main(String[] args) {

        user_data(users_contacts);
        users_contacts.forEach((k, v) -> System.out.println(v + ", " + k));
         System.out.println("=".repeat(30));
         making_changes(keys, users_contacts);
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

    private static void making_changes(Set<String> ss, HashMap<String, String> hm) {
        Iterator<String> it = ss.iterator();
        while (it.hasNext()) {
            String v = hm.get(it.next());
            System.out.println(v + ", ");

        }
    }


}



