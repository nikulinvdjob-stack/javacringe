package arena.heroes;

public class Archer extends Hero {
    private int arrowCount;

    public Archer(String name, int level, float health, int arrowCount) {
        super(name, level, health);
        this.arrowCount = arrowCount;
    }

    @Override
    public void attack() {
        System.out.println(Hero.archerAttackAlert);
        System.out.println();
    }
}
