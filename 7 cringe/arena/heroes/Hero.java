package arena.heroes;

import arena.app.App;

public abstract class Hero {

    String name;
    int level;
    float health;
    static final int MAX_LEVEL = 100;
    static int heroesCreated;

    static final String knightAttackAlert = "Рыцарь бьет мечом!";
    static final String archerAttackAlert = "Лучник выпускает стрелу!";
    static final String mageAttackAlert = "Маг запускает огненный шар!";

    float healthMax;
    static final float HP_PER_LEVEL = 25;
    static final float MANA_PER_LEVEL = 25;


    public Hero(String name, int level, float health) {
        this.name = name;
        this.level = Math.clamp(level, 1, MAX_LEVEL);
        this.healthMax = this.level * HP_PER_LEVEL;
        this.health = Math.clamp(health, 0, healthMax);
        heroesCreated++;

    }

    public void printInfo() {
        System.out.printf(String.format(
                "🏷️ Имя героя: %s%n" +
                "💪 Уровень героя: %s | (%d/%d)%n" +
                "❤️ Текущее здоровье: %s | (%.2f/%.2f)%n%n",
                this.name,
                App.getStringProgressBar(this.level, MAX_LEVEL, "lvl"),
                this.level,
                MAX_LEVEL,
                App.getStringProgressBar(this.health, this.healthMax, "hp"),
                this.health,
                this.healthMax));
    }

    public void takeDamage(int damage) {
        this.health = Math.max(health - damage, 0);
    }

    public void levelUp() {
        this.level = Math.min(++level, MAX_LEVEL);
        this.healthMax = this.level * HP_PER_LEVEL;
    }

    public void attack() {
        System.out.println("Герой наносит обычный удар!");
    }

    public void attack(String target) {
        System.out.println("Герой наносит обычный удар. 🎯Цель: " + target);
    }

    public void attack(String target, int times) {
        System.out.printf(String.format("Герой атакует цель 🎯Цель: %s %d раз", target, times));
        System.out.println();
    }

    public static void printHeroesCreated() {
        System.out.println("Всего создано героев: " + heroesCreated);
    }

    public final void rest() {
        System.out.println("Герой отдыхает и восстаналивает силы.");

        this.health = this.healthMax;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return this.name;
    }

    public float getHealth() {
        return health;
    }

    public float getHealthMax() {
        return healthMax;
    }
}
