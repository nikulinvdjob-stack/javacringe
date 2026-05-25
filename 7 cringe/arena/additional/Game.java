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

    static final float START_VALUE = 999999f;
    static final String DIALOG_HERO_TYPE = """
                Создай героя! Выбери клас (введи 1/2/3):
                1 - Рыцарь⚔️
                2 - Лучник🏹
                3 - Маг🔮""";
    static final String DIALOG_GAME_ACTION = """
                Выбери действие (введи 1/2/3):
                1 - Показать информацию о героеℹ️
                2 - Драться👿
                3 - Завершить игру🚪""";
    static final String DIALOG_FIGHT_ACTION = """
                    Что будет делать герой? (введи 1/2/3/4):
                    1 - Ударить👊
                    2 - Отдохнуть😴
                    3 - Проверить себяℹ️
                    4 - Убежать🏃""";
    static final String GAME_OVER_ALERT = "😔😔Вас победили, вы убежали домой и легли спать. Позорище.\n";
    static final String LEVEL_UP_ALERT = "🏆Противник побежден, вы прокачались!\n";
    static final String ENCOUNTER_AN_ENEMY_ALERT = "На вас выскочил дикий %s, на вид он %d уровня!%n%n";
    static final String HERO_DAMAGE_ALERT = "Вы нанесли %d урона.%n Здоровье противника: %s%n%n";
    static final String ENEMY_DAMAGE_ALERT = "Вам нанесли %d урона%n%n";

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

        int heroType = userInputHandler(DIALOG_HERO_TYPE, 3);

        String heroName = "";
        System.out.println("Назови своего героя: ");
        while (heroName.equals("")) {
            heroName = scanner.nextLine();
        };

        switch (heroType) {
        case 1:
            hero = new Knight(
                    heroName,
                    1,
                    START_VALUE,
                    START_VALUE);
            break;
        case 2:
            hero = new Archer(
                    heroName,
                    1,
                    START_VALUE,
                    10);
            break;
        case 3:
            hero = new Mage(
                    heroName,
                    1,
                    START_VALUE,
                    START_VALUE);
            break;
    }

    Game.ChooseAction();
    }

    static void ChooseAction() {

        int gameAction = userInputHandler(DIALOG_GAME_ACTION, 3);

        switch (gameAction) {
            case 1:
                hero.printInfo();
                Game.ChooseAction();
                break;
            case 2:
                Game.Fight();
                break;
            case 3:
                System.out.println("Конец.");
                break;
        }

    }

    static void Fight() {

        Enemy enemy = new Enemy(
                "Гоблин",
                hero.getLevel() + getRandomRange(-5, 5),
                START_VALUE);

        System.out.printf(String.format(
                ENCOUNTER_AN_ENEMY_ALERT,
                enemy.getName(),
                enemy.getLevel()));

        int heroAction = 0;
        int heroDamage = hero.getLevel() + getRandomRange(0, hero.getLevel() + enemy.getLevel() * 5);
        int enemyDamage = enemy.getLevel() + getRandomRange(-enemy.getLevel(), enemy.getLevel());

        do {

            heroAction = userInputHandler(DIALOG_FIGHT_ACTION, 4);

            int attackCounts = 1 + getRandomRange(0, 1) * getRandomRange(0, 5);

            switch (heroAction) {
                case 1:

                    if (attackCounts == 1)
                        hero.attack(true);
                    else
                        hero.attack(enemy.getName(), attackCounts);
                    enemy.takeDamage(heroDamage * attackCounts);

                    System.out.printf(String.format(
                            HERO_DAMAGE_ALERT,
                            heroDamage,
                            App.getStringProgressBar(enemy.getHealth(), enemy.getMaxHealth(), "hp")));

                    if (enemy.getHealth() == 0) {
                        System.out.println(LEVEL_UP_ALERT);
                        hero.levelUp();
                        Game.ChooseAction();
                    } else {
                        hero.takeDamage(enemyDamage);
                        System.out.printf(String.format(ENEMY_DAMAGE_ALERT, enemyDamage));
                    }
                    break;
                case 2:
                    hero.rest(true);
                    break;
                case 3:
                    hero.takeDamage(enemyDamage);
                    break;
            }

        } while (heroAction != 4 && hero.getHealth() > 0);

        if (hero.getHealth() == 0) {
            System.out.println(GAME_OVER_ALERT);
            hero.rest(true);
        }

        Game.ChooseAction();
    }
}
