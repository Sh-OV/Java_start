import java.util.Random;

public class Main {
    static int i;          // 32 bit
    static long l;         // 64 bit
    static byte b;         // 8 bit
    short sh;       // 16 bit
    float fl;       // 32 bit floating poin
    double d;       // 64 bit floating poin
    static boolean bool;   // true, false
    char ch;        // 16 bit без знака
    String string = "Привет Мир"; // Ссылочный (классовый) тип данных
    String s = new String("Привет мир");    // Раньше должно было быть такое объявление переменной
    static int[] ints = new int[10];

    public static void main(String[] args) {

        ints[3] = 10;
        int[] tmp = new int[ints.length * 2 + 1];

        Random random = new Random();

        for (int j=0 ; j<ints.length ; j++) {
            tmp[j] = ints[j] + random.nextInt(100);
        }
        tmp[15] = 5;
        ints = tmp;

        for (int i: ints) {
            System.out.println(i);
        }


        if (bool) {
            getInt(String.valueOf(12));
        } else if ( l > i) {
            getInt(String.valueOf(13));
        } else {
            getInt(String.valueOf(14));
        }

        System.out.println(Integer.toBinaryString(158));
        System.out.println(
                Integer.toBinaryString(158).length()
        );

    }

    static int getInt(String strToInt){
        int i = 0;
        Main.l = i;
        return Integer.parseInt(strToInt);
    }

    static void print(String str){
        System.out.println(str);
    }
}