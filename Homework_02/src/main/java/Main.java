/*
Урок 2. Почему вы не можете не использовать API
1. Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
2. Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).
3* Напишите программу, чтобы перевернуть строку с помощью рекурсии.
4. Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
6. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
7* Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.
 */

public class Main {
    static String str_1 = "";
    static String str_2 = "";
    static StringBuilder str_b1 = new StringBuilder();
    static StringBuilder str_b2 = new StringBuilder();

    public static void main(String[] args) {
//1. Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
        str_1 = "Привет! Давайте знакомиться";
        str_2 = "Привет!";
        Entry(str_1, str_2);
// 2. Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).
        str_2 = str_1;
        str_1 = String.valueOf(new StringBuilder(str_1).reverse());
        Entry_revers(str_1, str_2);
// 3* Напишите программу, чтобы перевернуть строку с помощью рекурсии.
        str_2 = Revers_recurs(str_2);
        System.out.println("Перевернутая строка выглядит так: " + str_1);
// 4. Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
        str_b2.  append(3).append(" + ").append(56).append(" = ").append(3+56).append(" ").
                append(3).append(" - ").append(56).append(" = ").append(3-56).append(" ").
                append(3).append(" * ").append(56).append(" = ").append(3*56);
        System.out.println(str_b2);
// 5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
        str_b1 = str_b2;
        Replacement_1var(str_b1,"=", "равно");
        System.out.println(str_b1);
// 6. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
//      str_b2.replace(7,8,"равно");
        Replacement_2var(str_b2,"=", "равно");
        System.out.println(str_b2);
//7* Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.
        String equally = "=".repeat(1000);
        Test_time_str(equally, "равно");
        Test_time_builder();
    }
     public static boolean Entry(String str1, String str2) {
        boolean result = str1.equals(str2);
        System.out.println("Вхождение в строке: " + result);
        return result;
        }
    public static boolean Entry_revers(String str1, String str2) {
        str2 = String.valueOf(new StringBuilder(str2).reverse());
        boolean result = str1.equals(str2);
        System.out.println("являются ли две данные строки вращением друг друга?: " + result);
        return result;
    }

    public static String Revers_recurs(String str) {            // Метод реверсирования строки с использованием рекурсии
        if (str == null || str.equals("")) {                    // если строка пустая
            return str;
        }
        return str.charAt(str.length() - 1) + Revers_recurs(str.substring(0, str.length() - 1));
                                                                // последний символ + повтор для оставшейся строки
    }
    public static void Replacement_1var( StringBuilder str_b1, String str1, String str2) {
        for (int i = 0; i < str_b1.length(); i++) {
            String a = String.valueOf(str_b1.charAt(i));
            if (a.equals(str1)){
                str_b1.deleteCharAt(i);
                str_b1.insert(i, str2);
            }
        }
    }

    public static void Replacement_2var(StringBuilder str_b2, String str1, String str2) {
        for (int i = 0; i < str_b2.length(); i++) {
            String a = String.valueOf(str_b2.charAt(i));
         if (a.equals(str1)){
             str_b2.replace(i,i+1,str2);
         }
        }
    }

    public static int Test_time_str(String str1, String str2) {            // Метод проверки скорости работы строк
        long start = System.currentTimeMillis();
        str1.replaceAll("=", str2);
        long end = System.currentTimeMillis();
        int res = (int) (end - start);
        System.out.println("Скорость работы String: " + res);
        return res;
            }
    public static int Test_time_builder() {            // Метод проверки скорости работы стрингбилдера
        str_b1.delete(0,str_b1.length());
       for (int i = 0; i < 1000; i++) {
            str_b1.append("=");
            }
        long start = System.currentTimeMillis();
        for (int i = 0; i < str_b1.length(); i++) {
            String a = String.valueOf(str_b1.charAt(i));
            if (a.equals("=")) {
                str_b1.replace(i, i + 1, "равно");
            }
        }
        long end = System.currentTimeMillis();
        int res = (int) (end - start);
        System.out.println("Скорость работы StringBuilder : " + res);
        return res;
    }

}




