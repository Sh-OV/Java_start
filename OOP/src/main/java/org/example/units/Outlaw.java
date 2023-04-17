package org.example.units;

public class Outlaw extends Infantry {


    public Outlaw() {

        super(1,1, 40, 6, 18, 8, new int[]{8,12}, 2,30);
    }
    @Override
    public String getInfo() {
        return "Вор - ";
    }
}
