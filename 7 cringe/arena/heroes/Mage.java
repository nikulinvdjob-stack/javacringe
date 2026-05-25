package arena.heroes;

public class Mage extends Hero {
    private float mana;
    private float maxMana;
    static final float MANA_PER_LEVEL = 25;
    static final float MANA_PER_HIT = 5;

    static final String MAGE_ATTACK_ALERT = "Маг запускает огненный шар!\n";
    static final String MAGE_NO_MANA_LEFT = "🚨Не хватает маны, нужно отдохнуть!\n";

    public Mage(String name, int level, float health, float mana) {
        super(name, level, health);
        updateMaxMana();
        mana = Math.clamp(mana, 0, maxMana);
    }

    @Override
    public void attack() {
        System.out.println(MAGE_ATTACK_ALERT);
        System.out.println();
    }

    @Override
    public void levelUp() {
        super.levelUp();
        updateMaxMana();
    }

    @Override
    public void attack(boolean isInTheGame) {
        if (mana >= MANA_PER_HIT) {
            System.out.println(MAGE_ATTACK_ALERT);
            System.out.println();
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
