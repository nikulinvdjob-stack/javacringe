package arena.heroes;

public class Mage extends Hero {
    float mana;
    float manaMax;

    public Mage(String name, int level, float health, float mana) {
        super(name, level, health);
        this.manaMax = this.level * MANA_PER_LEVEL;
        this.mana = Math.clamp(mana, 0, manaMax);
    }

    @Override
    public void attack() {
        System.out.println(Hero.mageAttackAlert);
        System.out.println();
    }

    @Override
    public void levelUp() {
        this.level = Math.min(++level, MAX_LEVEL);
        this.healthMax = this.level * HP_PER_LEVEL;
        this.manaMax = this.level * MANA_PER_LEVEL;
    }
}
