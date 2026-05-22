package arena.heroes;

public class Knight extends Hero {
    private float armor;

    public Knight(String name, int level, float health, float armor) {
        super(name, level, health);
        this.armor = armor;
    }

    @Override
    public void attack() {
        System.out.println(Hero.knightAttackAlert);
        System.out.println();
    }

    /*@Override
    public final void rest() {
        System.out.println("Рыцарь отдыхает и восстаналивает силы.");
    }*/
}
