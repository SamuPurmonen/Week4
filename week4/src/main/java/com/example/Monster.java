package com.example;

import java.io.Serializable;

public class Monster implements Serializable {

    String type;
    int Health;

    public Monster(String type, int Health){
        this.type = type;
        this.Health = Health;
        

    }


    public void Printinfo(int number){
        
        System.out.println(number + ": " + type +" / "+Health);

    }

    public boolean takeDamage(int dmg){
        this.Health = this.Health-dmg;
        if (this.Health <= 0){

            return true;
                // this poistaa siis kyseisen olion mikä kutsui tätä ohjelmaa eli playerissa Target olio indeksillä x
        }
        else{
            return false;
        }

    }
}
