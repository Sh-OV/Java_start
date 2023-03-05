/*
Первый семинар.
1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

Пункты реализовать в методе main
*Пункты реализовать в разных методах

int i = new Random().nextInt(k); //это кидалка случайных чисел!)
 */

import java.util.Random;
public class Main {
    static int i;
    static int n;

    public static void main(String[] args) {
        // 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
        System.out.print("1. Выброшенное случайное целое число i = ");
        PrintInt(Random(0, 2001));
        // 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        System.out.println("2. У выпавшего числа i номер старшего значащего бита n = " + Bit(i));
        // 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        int k = i;
        int len_max = Short.MAX_VALUE - i;
        int len_m1 = LenArr(i, Short.MAX_VALUE, n);
        int[] m1 = new int[len_m1];
        int count = 0;
        for (int j = 0; j < len_max; j++) {
            if (Multiple(k, n)) {
                m1[count] = k;
                count ++;
            }
            k++;
        }
        System.out.println("\n 3. Все кратные " +  n + " числа в диапазоне от " + i + " до " + Short.MAX_VALUE + ":");
        PrintArr(m1);
//4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
        k = i;
        int len_min = i - Short.MIN_VALUE;
        int len_m2 = len_min + 1 - LenArr(Short.MIN_VALUE, i, n);
        int[] m2 = new int[len_m2];
        count = 0;
        for (int j = 0; j < len_min; j++) {
            if (!Multiple(k, n)) {
                m2[count] = k;
                System.out.println("m2[" + count+ "] = " + m2[count] + "; k = " + k + "; count = " + count);
                count ++;
            }
            k++;
        }
        System.out.println("\n 4. Все некратные " +  n + " числа в диапазоне от " + Short.MIN_VALUE + " до " + i + ":");
        PrintArr(m2);
    }

    static int Random(int start, int finish){
        i =new Random().nextInt(start, finish);
        return i;
    }

    static void PrintInt(int num){
        System.out.println(num);
    }

    static void PrintArr(int[] arr){
          System.out.print("{");
        for (int j = 0; j < arr.length-1; j++) {
            if (j > 9 && j % 10 == 0) {
                System.out.print(arr[j] + ", \n");
            }
            System.out.print(arr[j] + ",");
        }
          System.out.println(arr[arr.length-1] + "}");
    }

    static boolean Multiple(int number, int div){
        boolean result;
        if(number % div == 0){
            result = true;
        }
        else result = false;
        return result;
    }

    static int Bit(int count){
        n = Integer.highestOneBit(count);
        return n;
    }

    static int LenArr(int min, int max, int div){
        int res = 0;
        if ((max - min)/div != 0){
            res = (max - min)/div + 1;
        }
        else res = (max - min)/div;
        return res;
    }
}


