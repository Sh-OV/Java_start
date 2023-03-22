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

public class Main {
    static LinkedList<ArrayList<String>> contact_users = new LinkedList<>();
    static Scanner user_scan = new Scanner(System.in);

    public static void main(String[] args) {
        data_entry_conditions(contact_users);
        print_user(contact_users);
        sorting_index(contact_users,3);
        print_user(contact_users);
    }

    private static ArrayList<String> user_data_entry() {
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

    private static void print_user(LinkedList<ArrayList<String>> lls) {
        for (int j = 0; j < lls.size(); j++) {
            System.out.print(lls.get(j).get(0) + " ");
            System.out.print(lls.get(j).get(1).toUpperCase().charAt(0) + ".");
            System.out.print(lls.get(j).get(2).toUpperCase().charAt(0) + ". ");
            System.out.print(lls.get(j).get(3) + " ");
            System.out.println(lls.get(j).get(4));
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
                if (Integer.parseInt(o1.get(arg)) > Integer.parseInt(o2.get(arg))) return 1;
                else if (Integer.parseInt(o1.get(arg)) < Integer.parseInt(o2.get(arg))) return -1;
                else return 0;
            }
        };
        lls.sort(sorting);
    }

 /*   public static void sorting_index_1(LinkedList<Integer> lli, LinkedList<ArrayList<String>> lls, int arg) {
        //LinkedList <Integer> temp = new LinkedList<>();
        //temp = lli;
        for (int i = 0; i < lls.size()-1; i++) {
            for(int j = 0; j < lls.size() - i-1; j++) {
            if (Integer.parseInt(lls.get(j).get(arg)) > Integer.parseInt(lls.get(j + 1).get(arg))) {
                System.out.println("lli.get(j) = " + lli.get(j) + "\n" +
                                    "lli.get(j+1) = " + lli.get(j-1));
                int help = lli.get(j);
                lli.set(j,(j+1));
                lli.set((j+1),help);
                System.out.println("lli.get(j) = " + lli.get(j) + "\n" +
                        "lli.get(j+1) = " + lli.get(j-1));
            }
            }
        }
        System.out.println(lli);
    }
*/



}
