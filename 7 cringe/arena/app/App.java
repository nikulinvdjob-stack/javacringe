package arena.app;

import arena.additional.Game;
import arena.heroes.Archer;
import arena.heroes.Hero;
import arena.heroes.Knight;
import arena.heroes.Mage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {

    public static String getStringProgressBar(float current, float max, String type) {

        StringBuilder hpBar = new StringBuilder();
        int barLength = 10;
        float ratio = (float) current / max;
        String barPositiveSegment = "";
        String barNegativeSegment = "";

        switch (type) {
            case "hp":
                barPositiveSegment = "🟩";
                barNegativeSegment = "🟥";
                break;
            case "lvl":
                barPositiveSegment = "🟦";
                barNegativeSegment = "⬜";
                break;
        }

        for (int i = 0; i < barLength; i++) {
            hpBar.append((float) i / barLength >= ratio ? barNegativeSegment : barPositiveSegment);
        }

        return hpBar.toString();
    }

    static void main() throws IOException {

        Answers.CreateAnswers();

        Hero[] heroes = {
                new Knight(
                        "Рыцарь",
                        1,
                        50.0f,
                        10.0f),

                new Archer(
                        "Лучник",
                        200,
                        60.0f,
                        5),

                new Mage(
                        "Волшебник",
                        3,
                        -70.0f,
                        30.0f)
        };

        for (Hero h : heroes) {
            h.printInfo();
            h.attack();
        }

        final Knight knight = new Knight(
                "Финальный Рыцарь",
                50,
                500.0f,
                20.0f);
        knight.printInfo();
        knight.levelUp();
        knight.printInfo();

        //дополнительная часть
        Game.createHero();

    }
}
