/*
Несколько дней не могла сделать задание.
По лекции преподавателя по д/з наконец-то смогла )))

Урок 5. Хранение и обработка данных ч2: множество коллекций Map
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов. Пусть дан список сотрудников.
Напишите программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности имён.
*Популярность не имён а номеров телефонов
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) {
        dataBase();
        getEmployees();
        getPopularName(0);
    }

    static HashMap<Integer, ArrayList<String>> employees = new HashMap<>();
    static Integer keyEmployee = 0;

    private static void dataBase() {
        addEmployees("Иван", "Иванов", createPhoneNumber());
        addEmployees("Светлана", "Петрова", createPhoneNumber());
        addEmployees("Кристина", "Белова", createPhoneNumber());
        addEmployees("Анна", "Мусина", createPhoneNumber());
        addEmployees("Анна" , "Крутова", createPhoneNumber());
        addEmployees("Иван", "Юрин", createPhoneNumber());
        addEmployees("Петр","Лыков", createPhoneNumber());
        addEmployees("Павел","Чернов", createPhoneNumber());
        addEmployees("Петр","Чернышов", createPhoneNumber());
        addEmployees("Мария","Федорова", createPhoneNumber());
        addEmployees("Марина","Светлова", createPhoneNumber());
        addEmployees("Мария","Савина", createPhoneNumber());
        addEmployees("Мария","Рыкова", createPhoneNumber());
        addEmployees("Марина","Лугова", createPhoneNumber());
        addEmployees("Анна","Владимирова", createPhoneNumber());
        addEmployees("Иван","Мечников", createPhoneNumber());
        addEmployees("Петр","Петин", createPhoneNumber());
        addEmployees("Иван","Ежов", createPhoneNumber());
    }

    private static void addEmployees(String firstName, String lastName, String phone) {
        keyEmployee += 1;
        ArrayList<String> empl = new ArrayList<>();
        empl.add(firstName);
        empl.add(lastName);
        empl.add(phone);
        employees.put(keyEmployee, empl);
    }

    private static String createPhoneNumber() {
        String number = "+7-9";
        Random random = new Random();
        int num = random.nextInt(900000000 - 110000000) + 110000000;
        String phoneNumber = Integer.toString(num);
        number += phoneNumber;
        return number;
    }
    private static void getEmployees(){
        for (Integer key: employees.keySet()) {
            System.out.println(key + "=" +employees.get(key));
        }
    }
    private static void getPopularName(Integer id){
        TreeMap<String, Integer> tmpTree = new TreeMap<>();
        employees.forEach((k, v) -> tmpTree.put(v.get(0), 0));
        int[] tmpCnt = new int[]{0, 0};
        String[] strings = new String[]{""};
        for (String name: tmpTree.keySet()) {
            tmpCnt[0] = tmpTree.get(name);                          // обнуление нового счетчика
            employees.forEach((k, v) -> {
                if(v.get(0).equals(name)) tmpCnt[0]++;
                if(tmpCnt[0]>tmpCnt[1]){
                    tmpCnt[1] = tmpCnt[0];
                    strings[0] = name;
                }
            });
        }
        System.out.println("Имя " + strings[0] + " повторяется " + tmpCnt[1] + " раз");
    }
}
