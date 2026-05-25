package arena.heroes;

import arena.app.App;

public abstract class Hero {

    private String name;
    private int level;
    private float health;
    static final int MAX_LEVEL = 100;
    static int heroesCreated;

    static final String HERO_REST_ALERT = "Герой отдыхает и восстаналивает силы.\n";
    static final String HERO_ATTACK_ALERT = "Герой наносит обычный удар!\n!";
    static final String HERO_TARGET_ATTACK_ALERT = "Герой наносит обычный удар. 🎯Цель: %s%n%n";
    static final String HERO_TARGET_MULTI_ATTACK_ALERT = "Герой атакует цель 🎯Цель: %s %d раз!%n%n";

    static final float HP_PER_LEVEL = 25;
    private float maxHealth;

    public Hero(String name, int level, float health) {
        this.name = name;
        this.level = Math.clamp(level, 1, MAX_LEVEL);
        updateMaxHealth();
        this.health = Math.clamp(health, 0, maxHealth);
        heroesCreated++;

    }

    public void printInfo() {
        System.out.printf(String.format(
                "🏷️ Имя героя: %s%n" +
                "💪 Уровень героя: %s | (%d/%d)%n" +
                "❤️ Текущее здоровье: %s | (%.2f/%.2f)%n%n",
                name,
                App.getStringProgressBar(level, MAX_LEVEL, "lvl"),
                level,
                MAX_LEVEL,
                App.getStringProgressBar(health, maxHealth, "hp"),
                health,
                maxHealth));
    }

    public void takeDamage(int damage) {
        health = Math.max(health - damage, 0);
    }

    public void levelUp() {
        level = Math.min(++level, MAX_LEVEL);
        updateMaxHealth();
    }

    public void attack() {
        System.out.println(HERO_ATTACK_ALERT);
    }

    public void attack(String target) {
        System.out.println(String.format(HERO_TARGET_ATTACK_ALERT, target));
    }

    public void attack(String target, int times) {
        System.out.printf(String.format(HERO_TARGET_MULTI_ATTACK_ALERT, target, times));
    }

    public static void printHeroesCreated() {
        System.out.println("Всего создано героев: " + heroesCreated + "\n");
    }

    public final void rest() {
        System.out.println(HERO_REST_ALERT);
        health = maxHealth;
    }

    public void rest(boolean isInTheGame) {
        System.out.println(HERO_REST_ALERT);
        health = maxHealth;
    }

    public void attack(boolean isInTheGame) {
        System.out.println(HERO_ATTACK_ALERT);
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public float getHealth() {
        return health;
    }

    public float getMaxHealth() {
        return maxHealth;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMaxHealth(float maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public void updateMaxHealth() {
        maxHealth = level * HP_PER_LEVEL;
    }

}
