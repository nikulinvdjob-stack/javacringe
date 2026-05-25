package arena.heroes;

import arena.app.App;

public class Mage extends Hero {
    private float mana;
    private float maxMana;

    static final float MANA_PER_LEVEL = 25;
    static final float MANA_PER_HIT = 5;

    static final String MAGE_ATTACK_ALERT = "Маг запускает огненный шар! Осталось маны:%n%s%n%n";
    static final String MAGE_NO_MANA_LEFT = "🚨Не хватает маны, нужно отдохнуть!\n";

    public Mage(String name, int level, float health, float mana) {
        super(name, level, health);
        updateMaxMana();
        this.mana = Math.clamp(mana, 0, maxMana);
    }

    @Override
    public void attack() {
        System.out.printf(MAGE_ATTACK_ALERT, App.getStringProgressBar(mana, maxMana, "mana"));
    }

    @Override
    public void levelUp() {
        super.levelUp();
        updateMaxMana();
    }

    @Override
    public void attack(boolean isInTheGame) {
        if (mana >= MANA_PER_HIT) {
            attack();
            mana -= MANA_PER_HIT;
        } else {
            System.out.println(MAGE_NO_MANA_LEFT);
        }
    }

    public void updateMaxMana() {
        maxMana = getLevel() * MANA_PER_LEVEL;
    }

    @Override
    public void rest(boolean isInTheGame) {
        setHealth(getMaxHealth());
        mana = maxMana;
    }
}
