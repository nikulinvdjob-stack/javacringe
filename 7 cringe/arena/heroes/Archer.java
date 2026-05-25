package arena.heroes;

public class Archer extends Hero {
    private int arrowCount;
    private int maxArrows;

    static final int ARROWS_PER_REST = 5;
    static final int ARROWS_PER_LEVEL = 2;

    static final String ARCHER_ATTACK_ALERT = "Лучник выпускает стрелу! Осталось стрел: %d%n%n";
    static final String ARCHER_NO_ARROWS_LEFT = "🚨Нет стрел, нужно отдохнуть!\n";

    public Archer(String name, int level, float health, int arrowCount) {
        super(name, level, health);
        updateMaxArrows();
        this.arrowCount = Math.clamp(arrowCount, 0, maxArrows);
    }

    @Override
    public void attack() {
        System.out.printf(String.format(ARCHER_ATTACK_ALERT, arrowCount));
    }

    @Override
    public void levelUp() {
        super.levelUp();
        updateMaxArrows();
    }

    @Override
    public void rest(boolean isInTheGame) {
        setHealth(getMaxHealth());
        arrowCount += Math.min(ARROWS_PER_REST, maxArrows);
    }

    public void attack(boolean isInTheGame) {
        if (arrowCount > 0) {
            attack();
            arrowCount--;
        } else {
            System.out.println(ARCHER_NO_ARROWS_LEFT);
        }
    }

    public void updateMaxArrows() {
        maxArrows = ARROWS_PER_LEVEL * getLevel();
    }
}
