package com.example;

import java.io.Serializable;

public class Player implements Serializable {
    String name;

    public Player(String Input){

        name = Input;
        
        
    }
        
    public void attack(Monster target){
        System.out.println(this.name + "hyökkää " + target.type + " hirviöön!");
        // kutsu Monsterin takedamagea
        System.out.println("Hirviöllä on "+ target.Health + " elämää jäljellä.");
        int dmg = 10;
        Boolean MonsterIsDead = target.takeDamage(dmg);
        
        
    }
}
