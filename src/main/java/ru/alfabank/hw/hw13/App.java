package ru.alfabank.hw.hw13;

import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class App {

    static final int CRINGE_ALIENS_NUMBER = 5;
    static final Faker faker = new Faker();

    static void main() {

        //1
        System.out.println("Задание 1--");

        ArrayList<Alien> aliens = new ArrayList<>();

        for (int i = 0; i < CRINGE_ALIENS_NUMBER; i++)
            aliens.add(new Alien(
                    i % 2 == 0 ? faker.starWars().character() : "SameName",
                    i % 2 == 0 ? faker.planet().name() : "SamePlaner",
                    i + 1));

        for (Alien alien : aliens)
            System.out.println(alien);

        for (int i = 0; i < aliens.size(); i++)
            for (int j = i + 1; j < aliens.size(); j++)
                if (aliens.get(i).equals(aliens.get(j)) && i != j) {
                    System.out.println("Есть дубликаты");
                    break;
                }

        //2
        System.out.println("Задание 2--");

        SquadManager squadManager = new SquadManager();
        squadManager.demonstrateListCreations();

        //3
        System.out.println("Задание 3--");

        List<String> squad = new ArrayList<>();

        for (int i = 0; i < 5; i++)
            squad.add(squadManager.GetName());
        squadManager.filterOutCowards(squad);;

        squad.clear();
        for (int i = 0; i < 5; i++)
            squad.add(squadManager.GetName());
        squadManager.filterOutCowardsRemoveIf(squad);

        //4
        System.out.println("Задание 4--");

        AssaultQueue assaultQueue = new AssaultQueue();

        for (int i = 0; i < 5; i++)
            assaultQueue.addRecruit(squadManager.GetName());

        assaultQueue.printQueue();

        System.out.println(assaultQueue.retreatCoward());
        System.out.println(assaultQueue.retreatCoward());

        for (int i = 0; i < 3; i++)
            assaultQueue.addRecruit(squadManager.GetName());

        assaultQueue.printQueue();

        //5
        System.out.println("Задание 5--");

        MissionReport missionReport1 = new MissionReport("Штурм ларька с Чекушками", aliens,squad.size());
        System.out.println(missionReport1);
        MissionReport missionReport2 = new MissionReport("Штурм ларька с Чекушками", aliens,squad.size());
        System.out.println("==: " + (missionReport1 == missionReport2 ? "Отчеты равны" : "Отчеты не равны"));
        System.out.println("equals: " + (missionReport1.equals(missionReport2) ? "Отчеты равны" : "Отчеты не равны"));
    }
}
