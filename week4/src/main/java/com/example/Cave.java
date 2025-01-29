package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;



public class Cave implements Serializable {

    ArrayList<Monster> monsterList = new ArrayList<>();
    Player player;
    
    


    public Cave(Player player) {
       
        this.player = player;

    }

    public void AddMonster(String monsterName, int monsterHealth){
        //Monster newMonster = new Monster(monsterName, monsterHealth);
        // monsterList.add(newMonster);

        monsterList.add(new Monster(monsterName, monsterHealth));

    }


    public void listMOnsters(){

        System.out.println("Luolan hirviöt:");
        for (int i = 0; i < monsterList.size(); i++){
            monsterList.get(i).Printinfo(i+1);
            
        }
    }

    public void saveData(String saveFileName){
        try {
            ObjectOutputStream gameWriter = new ObjectOutputStream(new FileOutputStream(saveFileName));
            gameWriter.writeObject(this);
            System.out.println("Peli tallennettiin tiedostoon " + saveFileName + ".");

        } catch (IOException e) {
            System.out.println("vituiks män.");
        }
        
        //sulkujen sisää mitä tallenneta
    }

    public void loadData(String saveFileName){
        try {
            ObjectInputStream gameReader = new ObjectInputStream(new FileInputStream(saveFileName));
            Cave loadedCave = (Cave) gameReader.readObject();
            this.monsterList = loadedCave.monsterList;
            this.player = loadedCave.player;
            System.out.println("Peli ladattu tiedostosta "+ saveFileName+". Tervetuloa takaisin, "+ player.name + ".");

            gameReader.close();

        } catch (Exception e) {
            System.out.println("vituiks män.");
        }
}
}