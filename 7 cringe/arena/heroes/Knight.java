package arena.heroes;

public class Knight extends Hero {
    private float armor;

    static final float KNIGHT_MAX_ARMOR = 75f;
    static final String KNIGHT_ATTACK_ALERT = "Рыцарь бьет мечом!\n";
    static final String KNIGHT_TAKE_DAMAGE_ALERT= "Рыцарские доспехи поглотили %.2f урона!\n";

    public Knight(String name, int level, float health, float armor) {
        super(name, level, health);
        updateArmor();
        armor = Math.clamp(armor, 0, this.armor);
    }

    @Override
    public void attack() {
        System.out.println(KNIGHT_ATTACK_ALERT);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        updateArmor();
    }

    public void updateArmor() {
        armor = KNIGHT_MAX_ARMOR * getLevel()/Hero.MAX_LEVEL;
    }

    @Override
    public void takeDamage(int damage) {
        float reducedDamage = damage * (1 - armor/100);
        System.out.printf(KNIGHT_TAKE_DAMAGE_ALERT, reducedDamage);
        setHealth(Math.max(getHealth() - (damage - reducedDamage), 0));
    }

    /*@Override
    public final void rest() {
        System.out.println("Рыцарь отдыхает и восстаналивает силы.");
    }*/
}
