import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Hw5 {
    static ArrayList<String> user = new ArrayList<>();
    static ArrayList<String> number_phone = new ArrayList<>();
    static Scanner user_scan = new Scanner(System.in);
    static HashMap<ArrayList<String>, ArrayList<String>> users_contacts = new HashMap<>();
    public static void main(String[] args) {
        user_data(user, number_phone);
    }

    private static void user_data(ArrayList<String> u, ArrayList<String> n, HashMap<ArrayList<String>, ArrayList<String>> uc) {
        String consol;
        System.out.println("Введите 'д' для ввода новой записи и любую клавишу для завершения ввода данных: ");
        consol = user_scan.nextLine();
        while (consol.equals("д")) {
            System.out.println("Контактное лицо: ");      // т.к. подключен файл из которого берутся данные, ввод из консоли неактуален
            String user = user_scan.nextLine();
            u.add(user);
            System.out.println("Номер телефона (11 цифр): ");
            String number_phone = user_scan.nextLine();
            n.add(number_phone);
            uc.put(u,n);
            System.out.println("Введите 'д' для ввода новой записи и любую клавишу для завершения ввода данных: ");
            consol = user_scan.nextLine();
        }
    }


}
