import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/*
Задания семинара:
1. Реализовать Set, в частности добавления элемента к сету, не используя сам Set
    (т.е. надо сделать программу, в которую можно добавлять элементы в любую коллекцию (на выбор, кроме Set),
    но вести себя Ваша  коллекция должна как сет, т.е. не должно быть двух одинаковых ключей)
 */
public class S6 {
    public static void main(String[] args) {
        MySet ms = new MySet();
        ms.add(1);
        ms.add(2);
        ms.add(3);
        ms.add(1);
        ms.print();
        MySet ms1 = new MySet();
        ms1.add(1);
        ms1.add(2);
        ms1.add(5);
        ms1.add(8);
        ms1.print();
        ms.united(ms1);
        ms.print();
        ms.delete(3);
        ms.print();
        System.out.println(ms.get(2));
        System.out.println(ms.toArrayKey());
        System.out.println(ms.toArrayValue(10));
    }
}

class MySet {
    private HashMap<Integer, Object> hm;
    private static final Object OBJECT = new Object();

    public MySet() {
        this.hm = new HashMap<>();
    }

    public void add(Integer num) {
        this.hm.putIfAbsent(num, OBJECT);

    }

    public void print() {
        hm.forEach((k, v) -> System.out.print(k));
        System.out.println();
    }

    public void united(MySet otherSet) {
        otherSet.hm.forEach((k, v) -> this.add(k));
    }

    public void delete(Integer num) {
        this.hm.remove(num);
    }

    /*   public void intersect(MySet otherSet){
           otherSet.hm.
       }*/
    public int size() {
        return this.hm.size();
    }

    public int get(int index) {
        return (int) this.hm.keySet().toArray()[index];
    }

    public ArrayList<Integer> toArrayKey() {
       return new ArrayList<Integer>(this.hm.keySet());
    }
    public ArrayList<Integer> toArrayValue(int element){
        if(!hm.containsKey(element)) return null;
        ArrayList<Integer> output = new ArrayList<>();
        for (int k : hm.keySet()) {
            output.add(k);
            if(k == element) break;
        }
        
       return output;
        }

    }



