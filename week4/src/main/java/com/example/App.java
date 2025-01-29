package com.example;

import java.util.Scanner;

public class App {
    
        public static void main( String[] args )
        {

            


            System.out.println( "Syötä pelaajan nimi: " );
            Scanner sc = new Scanner(System.in);
            String Input = sc.nextLine();


            Player player = new Player(Input);
            Cave cave = new Cave(player);
            
           
            

            


            boolean exit = false;
            while(!exit){
                System.out.println("1) Lisää luolaan hirviö\r\n" + //
                                        "2) Listaa hirviöt\r\n" + //
                                        "3) Hyökkää hirviöön\r\n" + //
                                        "4) Tallenna peli\r\n" + //
                                        "5) Lataa peli\r\n" + //
                                        "0) Lopeta peli");

                if(sc.hasNext()){
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);
                
                switch(i) {
                    case 1:
                    System.out.println("Anna hirviön tyyppi:");
                    String monsterName = sc.nextLine();

                    System.out.println("Anna hirviön elämän määrä numerona:");
                    String monsterHealthInput = sc.nextLine();

                    int monsterHealth = Integer.parseInt(monsterHealthInput);
                    
                    cave.AddMonster(monsterName, monsterHealth);
                    
                    
                    break;

                    case 2:
                    //menee Listmonster ohjelmaan

                    cave.listMOnsters();
                    if (cave.monsterList.isEmpty()){
                        System.out.println("Luola on tyhjä.");
                    }
        
                    break;

                    case 3:
                    System.out.println("Valitse hirviö, johon hyökätä: ");
                    cave.listMOnsters();
                    String attackTarget = sc.nextLine();
                    int Target = Integer.parseInt(attackTarget);
                    
                    cave.player.attack(cave.monsterList.get(Target-1));
                    
                    if (cave.monsterList.get(Target-1).Health<= 0){
                        System.out.println( cave.monsterList.get(Target-1).type  +" on kuollut!");
                        cave.monsterList.remove(Target-1);

                    }
                    break;

                    case 4:
                    System.out.println("Anna tiedoston nimi, johon peli tallentaa:");
                    String saveFileName = sc.nextLine();
                    cave.saveData(saveFileName);

                    break;

                    case 5:
                    System.out.println("Anna tiedoston nimi, josta peli ladataan:");
                    String LoadFileName = sc.nextLine();
                    cave.loadData(LoadFileName);
                    break;

                    case 0:
                    exit = true;
                    System.out.println("Peli päättyy. Kiitos pelaamisesta!");
                    break;

                    default:
                    System.out.println("syöte oli väärä.");
                    break;
                }
            }
        }
        }
}
