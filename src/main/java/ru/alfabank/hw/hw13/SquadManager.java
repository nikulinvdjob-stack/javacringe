package ru.alfabank.hw.hw13;

import net.datafaker.Faker;

import java.util.*;

public class SquadManager {
    static final Faker faker = new Faker();
    static final Random random = new Random();

    public String GetName() {
        return (random.nextBoolean() ? "" : "Трус ") + faker.starWars().character();
    }

    public void demonstrateListCreations() {
        List<String> mainSquad = new ArrayList<>();
        for(int i = 0; i < 4; i++)
            mainSquad.add(GetName());

        List<String> supportSquad = Arrays.asList(
                GetName(),
                GetName(),
                GetName(),
                GetName());

        List<String> eliteSquad = List.of(
                GetName(),
                GetName());

        String str = "Отряд %s, %s - %s%n";
        String squadType = "Основной";
        String actionType = "Добавление";

        try {
            mainSquad.add(faker.starWars().character());
            System.out.printf(str, squadType, actionType, "✅");
        } catch (Exception e) {
            System.out.printf(str, squadType, actionType,  "🚫: " + e.getClass().getSimpleName());
        }

        actionType = "Удаление";
        try {
            mainSquad.removeFirst();
            System.out.printf(str, squadType, actionType,  "✅");
        } catch (Exception e) {
            System.out.printf(str, squadType, actionType,  "🚫: " + e.getClass().getSimpleName());
        }

        squadType = "Поддержки";
        actionType = "Добавление";
        try {
            supportSquad.add(faker.starWars().character());
            System.out.printf(str, squadType, actionType, "✅");
        } catch (Exception e) {
            System.out.printf(str, squadType, actionType, "🚫: " + e.getClass().getSimpleName());
        }

        actionType = "Удаление";
        try {
            supportSquad.removeFirst();
            System.out.printf(str, squadType, actionType, "✅");
        } catch (Exception e) {
            System.out.printf(str, squadType, actionType, "🚫: " + e.getClass().getSimpleName());
        }

        squadType = "Элиты";
        actionType = "Добавление";
        try {
            eliteSquad.add(faker.starWars().character());
            System.out.printf(str, squadType, actionType, "✅");
        } catch (Exception e) {
            System.out.printf(str, squadType, actionType, "🚫: " + e.getClass().getSimpleName());
        }

        actionType = "Удаление";
        try {
            eliteSquad.removeFirst();
            System.out.printf(str, squadType, actionType, "✅");
        } catch (Exception e) {
            System.out.printf(str, squadType, actionType, "🚫: " + e.getClass().getSimpleName());
        }
    }

    public void filterOutCowards(List<String> squad) {
        System.out.println("До фильтрации: " + squad);
        Iterator<String> iterator = squad.iterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.startsWith("Трус")) {
                iterator.remove();
            }
        }
        System.out.println("После: " + squad);
    }

    public void filterOutCowardsRemoveIf(List<String> squad) {
        System.out.println("До фильтрации: " + squad);
        Iterator<String> iterator = squad.iterator();

        squad.removeIf(name -> name.startsWith("Трус"));
        System.out.println("После: " + squad);
    }
}
