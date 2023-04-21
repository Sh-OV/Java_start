package org.example.units;

import java.util.ArrayList;

public class Outlaw extends Infantry {


    public Outlaw() {

        super(8, 40, 6, 18, 8, new int[]{8,12}, 2, "stand",30);
    }
    @Override
    public String getInfo() {
        return "Разбойник - ";
    }
    }
