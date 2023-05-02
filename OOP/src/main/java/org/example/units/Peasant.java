package org.example.units;

import java.util.ArrayList;


public class Peasant extends BaseHero {
    public Peasant(Vector2D coords, int team) {
        super(2, 50,8, 5, 3, 15,30, team, coords.posX, coords.posY);
    }

    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> ally) {
        if(hp <= 0){
            this.condition = " \uD83D\uDC80 Dead";
            return;
        }

    }
    protected void search_ally_shooter(ArrayList<BaseHero> search_ally){     // поиск крестьянина
        for (BaseHero friend : search_ally) {
            if((friend.getInfo() == "Снайпер - " || friend.getInfo() == "Арбалетчик - ") &&
                    friend.hp > 0)
                System.out.println(toString() + " подносит стрелы " + friend.getInfo());
            return;
        }
        System.out.println(toString() + " некому подносить стрелы :-(");
    }
    @Override
    public String getInfo() {
        return "Фермер - ";
    }
}
