/*
Урок 3. Коллекции JAVA: Введение
1. Реализовать алгоритм сортировки списков компаратором.
2. Пусть дан произвольный список целых чисел, удалить из него чётные числа
3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
4. Дано два целочисленных списка, объеденить их не допуская элементы второго списка уже встречающиеся в первом.
5. Создать ArrayList<Integer> и добавить нулевым эллементом ноль 10000 раз.
6. Повторить пятый пункт но с LinkedList.
7. Сравнить время работы пятого и шестого пунктов.
 */
import java.util.*;

public class Main {

    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer> list1 = new ArrayList<>();
    static ArrayList<Integer> list2 = new ArrayList<>();
    public static void main(String[] args) {
        Random_List(list,10);
        System.out.println(list);
//1. Реализовать алгоритм сортировки списков компаратором.
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println(list);
//2. Пусть дан произвольный список целых чисел, удалить из него чётные числа
        Del_List(list, 2);
        System.out.println(list);
//3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
        Min_list(list);
        Max_list(list);
        Average_list(list);
//4. Дано два целочисленных списка, объеденить их не допуская элементы второго списка уже встречающиеся в первом.
        Random_List(list1,6);
        System.out.println(list1);
        Random_List(list2,6);
        System.out.println(list2);
//        Join_lists(list1, list2);
        Join_lists_2(list1, list2);
//5. Создать ArrayList<Integer> и добавить нулевым эллементом ноль 10000 раз.
        ArrayList<Integer> list3 = new ArrayList<>();
        Add_list_number(list3,10000, 0);
        System.out.println(list3);
//6. Повторить пятый пункт но с LinkedList.
        LinkedList<Integer> list4 = new LinkedList<>();
        Add_L_list_number(list4,10000, 0);
        System.out.println(list4);
//7. Сравнить время работы пятого и шестого пунктов.
        Test_time_ArrayList(list3);
        Test_time_LinkedList(list4);
    }
    public static void Random_List(ArrayList<Integer> l, int num){
        for (int j = 0; j < num; j++) {
            l.add(new Random().nextInt(num));
        }
    }


    public static void Del_List(ArrayList<Integer> l, int num) {
        for (int j = 0; j < l.size(); j++) {
            if (l.get(j) % num == 0) {
                l.remove(j);
                j--;
            }
        }
    }
    public static int Min_list(ArrayList<Integer> l){
        int min = Short.MAX_VALUE;
        for (int j = 0; j < l.size(); j++) {
            if (min > l.get(j)){
                min = l.get(j);
            }
        }
        System.out.println("min = " + min);
        return min;
    }
    public static int Max_list(ArrayList<Integer> l){
        int max = Short.MIN_VALUE;
        for (int j = 0; j < l.size(); j++) {
            if (max < l.get(j)){
                max = l.get(j);
            }
        }
        System.out.println("max = " + max);
        return max;
    }
    public static double Average_list(ArrayList<Integer> l){
        double average = 0;
        for (int j = 0; j < l.size(); j++) {
            average += l.get(j);
        }
        average = average/l.size();
        System.out.println("average = " + average);
        return average;
    }
    public static void Join_lists(ArrayList<Integer> l1, ArrayList<Integer> l2){
        l1.addAll(l2);
        Collections.sort(l1);
        System.out.println(l1);
        for (int i = 1; i < l1.size(); i++) {
            if (l1.get(i-1) == l1.get(i)){
                l1.remove(i);
                i--;
            }
        }
        System.out.println(l1);
    }
    public static void Join_lists_2(ArrayList<Integer> l1, ArrayList<Integer> l2){
        for (int i = 0; i < l1.size(); i++) {
            for (int j = 0; j < l2.size(); j++) {
                if (l1.get(i) == l2.get(j)){
                    l2.remove(j);
                    j--;
                }
            }
        }
        l1.addAll(l2);
        System.out.println(l1);
    }
    public static void Add_list_number (ArrayList<Integer> l, int count, int num){
        for (int i = 0; i < count; i++) {
            l.add(num);
        }
    }
    public static void Add_L_list_number (LinkedList<Integer> l, int count, int num){
        for (int i = 0; i < count; i++) {
            l.add(num);
        }
    }

    public static int Test_time_ArrayList(ArrayList<Integer> l) {
        l.removeAll(l);
        long start = System.currentTimeMillis();
        Add_list_number(l,10000, 0);;
        long end = System.currentTimeMillis();
        int res = (int) (end - start);
        System.out.println("Скорость работы ArrayList: " + res);
        return res;
    }
    public static int Test_time_LinkedList(LinkedList<Integer> l) {
        l.removeAll(l);
        long start = System.currentTimeMillis();
        Add_L_list_number(l,10000, 0);
        long end = System.currentTimeMillis();
        int res = (int) (end - start);
        System.out.println("Скорость работы LinkedList: " + res);
        return res;
    }
}
