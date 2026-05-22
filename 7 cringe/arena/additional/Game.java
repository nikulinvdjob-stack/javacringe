package arena.additional;

import arena.app.App;
import arena.heroes.Archer;
import arena.heroes.Hero;
import arena.heroes.Knight;
import arena.heroes.Mage;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Game {

    static Scanner scanner = new Scanner(System.in);
    static Hero hero = null;

    static int getRandomRange(int min,
                              int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    static int userInputHandler(String message,
                                 int answersCount) {
        int answer;

        do {
            System.out.println(message);
            answer = scanner.nextInt();
        } while (answer < 0 || answer > answersCount);

        return answer;
    }

    public static void createHero() {

        int heroType = userInputHandler(
                """
                
                Создай героя! Выбери клас (введи 1/2/3):
                1 - Рыцарь⚔️
                2 - Лучник🏹
                3 - Маг🔮""", 3);

        String heroName = "";
        System.out.println("Назови своего героя: ");
        while (heroName.equals("")){
            heroName = scanner.nextLine();
        };

            switch (heroType) {
            case 1:
                hero = new Knight(
                        heroName,
                        1,
                        999999f,
                        5.0f);
                break;
            case 2:
                hero = new Archer(
                        heroName,
                        1,
                        999999f,
                        10);
                break;
            case 3:
                hero = new Mage(
                        heroName,
                        1,
                        999999f,
                        999999f);
                break;
        }

        Game.ChooseAction();
    }

    static void ChooseAction() {

        int gameAction = userInputHandler(
                """
                
                Выбери действие (введи 1/2/3):
                1 - Показать информацию о героеℹ️
                2 - Драться👿
                3 - Завершить игру🚪""", 3);

        switch (gameAction) {
            case 1:
                hero.printInfo();
                Game.ChooseAction();
                break;
            case 2:
                Game.Fight();
                break;
            case 3:
                break;
        }

    }

    static void Fight() {

        Enemy enemy = new Enemy(
                "Гоблин",
                hero.getLevel() + getRandomRange(-5, 5),
                99999999f);

        System.out.printf(String.format(
                "На вас выскочил дикий %s, на вид он %d уровня!",
                enemy.getName(),
                enemy.getLevel()));

        int heroAction = 0;
        do {

            heroAction = userInputHandler(
                    """
                    
                    Что будет делать герой? (введи 1/2/3/4):
                    1 - Ударить👊
                    2 - Отдохнуть😴
                    3 - Проверить себяℹ️
                    4 - Убежать🏃""", 4);

            int heroDamage = hero.getLevel() + getRandomRange(0, hero.getLevel() + enemy.getLevel() * 5);
            int enemyDamage = enemy.getLevel() + getRandomRange(-enemy.getLevel(), enemy.getLevel());

            switch (heroAction) {
                case 1:
                    hero.attack();
                    enemy.takeDamage(heroDamage);

                    System.out.printf(String.format(
                            "Вы ударили и нанесли %d урона.%n" +
                            "Здоровье противника: %s%n",
                            heroDamage,
                            App.getStringProgressBar(enemy.getHealth(), enemy.getHealthMax(), "hp")));

                    if (enemy.getHealth() == 0) {
                        System.out.println("🏆Противник побежден, вы прокачались!");
                        hero.levelUp();
                        Game.ChooseAction();
                    } else {
                        hero.takeDamage(enemyDamage);
                        System.out.printf(String.format(
                                "Вас ударили и нанесли %d урона%n",
                                enemyDamage));
                    }
                    break;
                case 2:
                    hero.rest();
                    break;
                case 3:
                    hero.takeDamage(enemyDamage);
                    hero.printInfo();
                    break;
            }

        } while (heroAction != 4 && hero.getHealth() > 0);

        if (hero.getHealth() == 0) {
            System.out.printf("😔😔Вас победили, вы убежали домой и легли спать. Позорище.%n");
            hero.rest();
        }

        Game.ChooseAction();
    }
}
